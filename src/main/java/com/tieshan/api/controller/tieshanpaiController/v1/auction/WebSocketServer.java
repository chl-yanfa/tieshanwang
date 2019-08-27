package com.tieshan.api.controller.tieshanpaiController.v1.auction;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSONObject;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.CarPmAuctionMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.transaction.BidMapper;
import com.tieshan.api.util.resultUtil.WebSocketResult;
import com.tieshan.api.util.resultUtil.WebsocketConnUtil;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.OrderInfoVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {

//    @Autowired
//    private  BidMapper bidMapper;
//    @Autowired
//    private static CarPmAuctionMapper carPmAuctionMapper;

    static Log log= LogFactory.getLog(WebSocketServer.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //接收sid
    private String sid="";

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("sid") String sid) {
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        log.info("有新窗口开始监听:"+sid+",当前在线人数为" + getOnlineCount());
        this.sid=sid;
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }


    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {

        SimpleDateFormat sb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        WebSocketResult wb =  JSONObject.toJavaObject(JSONObject.parseObject(message), WebSocketResult.class);
        log.info("收到来自窗口"+sid+"的信息:"+message);
        try{
            BidMapper bidMapper =  (BidMapper) WebsocketConnUtil.getApplicationContext().getBean(BidMapper.class);
            CarPmAuctionMapper carPmAuctionMapper =  (CarPmAuctionMapper) WebsocketConnUtil.getApplicationContext().getBean(CarPmAuctionMapper.class);

            CarPmAuctionVo auctionDto = carPmAuctionMapper.getAuctionInfoByWS(wb.getCid());
            BigDecimal realPrice = auctionDto.getHighestPrice().add(auctionDto.getOtherPrice()).add(auctionDto.getCommission());

            OrderInfoVo ov =  bidMapper.getOrderInfoResultByWS(wb.getCid());
            WebSocketResult webs = new WebSocketResult();
            switch (ov.getOrderStatus()){
                case "2":
                    webs.setOrderStateS("等待竞拍");
                    break;
                case "4":
                    webs.setOrderStateS("正在竞拍");
                    break;
                case "5":
                    webs.setOrderStateS("成交");
                    break;
                case "8":
                    webs.setOrderStateS("流拍");
                    break;
            }
            webs.setAuction("xintiao");
            webs.setTotalPrice((auctionDto.getHighestPrice()==null)?"0":auctionDto.getHighestPrice().toString());
            webs.setStartTimeCount(sb.format(ov.getCompeteTime()));
            webs.setEndTimeCount(sb.format(ov.getCompeteOverTime()));
            webs.setOrderState(ov.getOrderStatus());
            webs.setRealPrice(realPrice==null?"0":realPrice.toString());
            //群发消息
            for (WebSocketServer item : webSocketSet) {
                try {
                    //item.sendMessage(message);
                    item.sendInfo(JSONObject.toJSONString(webs),wb.getUid());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     * */
    public static void sendInfo(String message,@PathParam("uid") String uid) throws IOException {
        log.info("推送消息到窗口"+uid+"，推送内容:"+message);
        for (WebSocketServer item : webSocketSet) {
            try {
                //这里可以设定只推送给这个uid的
                if(uid!=null) {
                    item.sendMessage(message);
                }
//                else if(item.sid.equals(uid)){
//                    item.sendMessage(message);
//                }
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}

