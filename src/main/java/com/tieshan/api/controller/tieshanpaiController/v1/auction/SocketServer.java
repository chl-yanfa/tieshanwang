package com.tieshan.api.controller.tieshanpaiController.v1.auction;

import com.alibaba.fastjson.JSONObject;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.auction.CarPmAuctionMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.transaction.BidMapper;
import com.tieshan.api.util.resultUtil.WebSocketResult;
import com.tieshan.api.util.resultUtil.WebsocketConnUtil;
import com.tieshan.api.vo.tieshanpaiVo.v1.auction.CarPmAuctionVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.OrderInfoVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/8/28 18:50
 */
@ServerEndpoint(value="/websocket/{userid}")
@Component
public class SocketServer {

    private static Log log= LogFactory.getLog(SocketServer.class);

    private Session session;

    private static Map<String,Session> sessionPool = new HashMap<>();

    private static Map<String,String> sessionIds = new HashMap<>();

    @OnOpen
    public void open(Session session, @PathParam(value="userid")String userid){
        this.session=session;
        sessionPool.put(userid,session);
        sessionIds.put(session.getId(),userid);
    }

    @OnMessage
    public void onMessage(String message){
        log.info("心跳状态下,当前在线用户数量:"+getOnlineNum());
        log.info("当前发送人的sessionid为:"+session.getId()+"发送内容为:"+message);

        /**
         * 通过客户端发送的数据，去操作数据库
         */
        SimpleDateFormat sb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        WebSocketResult wb =  JSONObject.toJavaObject(JSONObject.parseObject(message), WebSocketResult.class);
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
        try{
            sendToUser(JSONObject.toJSONString(webs),wb.getUid()+"_"+wb.getCid());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(){
        sessionPool.remove(sessionIds.get(session.getId()));
        sessionIds.remove(session.getId());
        log.info("关闭状态下,当前在线用户数量:"+getOnlineNum());
    }

    @OnError
    public void onError(Session session,Throwable error){
        error.printStackTrace();
    }

    public static void sendToUser(String message,String userId){
        Session s = sessionPool.get(userId);
        if(s!=null){
            try{
                log.info("向"+userId+"发送消息:"+message);
                s.getBasicRemote().sendText(message);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static int getOnlineNum(){
        return sessionPool.size();
    }

    public static String getOnlineUsers(){
        StringBuffer users = new StringBuffer();
        for (String key:sessionIds.keySet()) {
            users.append(sessionIds.get(key)+",");
        }
        return users.toString();
    }


    public static void sendAll(String msg){
        for (String key:sessionIds.keySet()) {
            sendToUser(msg,sessionIds.get(key));
        }
    }

}
