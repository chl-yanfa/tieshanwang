package com.tieshan.api.service.tieshanpaiService.v1.transaction.impl;


import com.tieshan.api.common.tieshanpaiCommon.v1.*;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.customer.CusCustomerMarginMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.customer.CusCustomerMarginWaterMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.transaction.BidMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.transaction.TraHighestBidMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.transaction.TraIndentMapper;
import com.tieshan.api.mapper.tieshanpaiMapper.v1.transaction.TraOfferWaterMapper;
import com.tieshan.api.po.tieshanpaiPo.v1.customer.CusCustomerMargin;
import com.tieshan.api.po.tieshanpaiPo.v1.customer.CusCustomerMarginWater;
import com.tieshan.api.po.tieshanpaiPo.v1.transaction.TraHighestBid;
import com.tieshan.api.service.tieshanpaiService.v1.transaction.BidService;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.BidVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.OrderInfoVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.TraOfferWaterVo;
import com.tieshan.api.vo.tieshanpaiVo.v1.transaction.TraOrderVo;
import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class BidServiceimple implements BidService {

	@Autowired
	private BidMapper bidMapper;
	@Autowired
	private TraIndentMapper traIndentMapper;
	@Autowired
	private CusCustomerMarginMapper cusCustomerMarginMapper;
	@Autowired
	private TraHighestBidMapper traHighestBidMapper;
	@Autowired
	private CusCustomerMarginWaterMapper cusCustomerMarginWaterMapper;
	@Autowired
	private TraOfferWaterMapper traOfferWaterMapper;


	/**
	 * 竞价
	 * @param bidDto
	 * @return
	 */
	@Override
	public ResultVO<String> bid(BidVo bidDto) {
		String dd = DateUtil.formatDate(new Date(), "yyyy/MM/dd HH:mm:ss:SSS");
		ResultVO<String> result = new ResultVO<String>();
		OrderInfoVo order = bidMapper.getOrderInfo(bidDto);
		if(order ==null){
			result.setReturnCode(Constants.RETURN_CODE_DATA_NULL);
			return result;
		}
		//	int FREEZEAMOUNT_MIN = Integer.parseInt(AuthorizationUtil.getInstance().getString("FREEZEAMOUNT_MIN"));
		BigDecimal FREEZEAMOUNT_MIN = order.getAuctionCashDeposit();
		bidDto.setFreezeAmount(FREEZEAMOUNT_MIN.intValue());
		bidDto.setOrderNo(order.getOrderNo());
		CusCustomerMargin cusCustomerMargin = new CusCustomerMargin();
		cusCustomerMargin.setUid(bidDto.getMemberCode());
		cusCustomerMargin = cusCustomerMarginMapper.getCusCustomerMarginByMember(cusCustomerMargin);
		int cha = cusCustomerMargin.getWalletPledge().compareTo(FREEZEAMOUNT_MIN);
		if(!bidDto.getMemberCode().equals(order.getMemberCode())){
			if (null == cusCustomerMargin || cha == -1 ) {
				result.setReturnCode(Constants.MARGIN_LESS);
				return result;
			}
		}
		bidDto.setSysDate(order.getSysDate());
		ResultVO<String> res = bidCheck(bidDto, order);
		if(!res.getReturnCode().equals(Constants.RETURN_CODE_SUCCESS)){
			return res;
		}
		String bidType = bidDto.getBidType();
		if(Constants.BID_TYPE_BIDDING.equals(bidType)){
			result = toBid(bidDto, order);
			return result;
		}

		return result;
	}


	/**
	 * 出价前判断
	 * @return
	 * @throws
	 */
	@Override
	public ResultVO<String> bidCheck(BidVo bidDto, OrderInfoVo order) {
		ResultVO<String> result = new ResultVO<String>();
		String bidType = bidDto.getBidType();
		if (Constants.BID_TYPE_BIDDING.equals(bidType)) {
			if (!order.getOrderStatus().equals(Constants.ORDER_STATUS_AUCTIONING)) {
				result.setReturnCode(Constants.QUOTEPRICE_NOT_SUPPORT);
				return result;
			}
			//是否已暂停

			//不是现场拍检查出价次数

			int newPrice = bidDto.getBidAmount();
			int maxPrice = 0;
			maxPrice = order.getBidMaxpriceUnlimited();
			//最小加价幅度
			int addExtent = Integer.valueOf(AuthorizationUtil.getInstance().getString("ADD_EXTENT"));
			//新价和最高价比较
			if(newPrice <= maxPrice){
				result.setReturnCode(Constants.PRICE_VERY_LOW);
				result.setPrice(maxPrice);
				result.setMemberCode((order.getMemberCode()).substring(1));
				return result;
				//最小加价幅度判断
			}else if((newPrice-maxPrice) < addExtent){
				result.setReturnCode(Constants.NOT_SMALLEST_INCREASE);
				return result;
			}
			// 开始时间判断
			if (order.getSysDate().before(order.getCompeteTime())) {
				result.setReturnCode(Constants.NOT_START);
				return result;
			}
			// 结束时间判断
			if (order.getSysDate().after(order.getCompeteOverTime())) {
				result.setReturnCode(Constants.ENDED);
				return result;
			}
			// 报价
		}
		result.setReturnCode(Constants.RETURN_CODE_SUCCESS);
		return result;
	}


	/**
	 * 出价
	 * @param
	 * @return
	 * @throws ParseException
	 */
	@Override
	public ResultVO<String> toBid(BidVo bidDto, OrderInfoVo order) {
		String cometContent = "";// 推送内容;
		ResultVO<String> res = new ResultVO<String>();
		// 价格判断
		// 如果是一口价
		try {
			//竞价
			if (Constants.BID_TYPE_BIDDING.equals(bidDto.getBidType())) {
				cometContent = biePrice(bidDto,order);// 调用出竞价接口
				// 推送消息
				CometUtil.pushMsg(Constants.COMET_TYPE_NEWPRICE,cometContent);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setReturnCode(Constants.RETURN_CODE_SYSTEM_FAIL);// 200000系统错误
			return res;
		}
		res.setReturnCode(Constants.RETURN_CODE_SUCCESS);
		return res;
	}


	/**
	 * 竞价
	 * @param bidDto
	 * @param order
	 * @return
	 */
	@Override
	public String biePrice(BidVo bidDto, OrderInfoVo order) {
		TraHighestBid traHighestBid = new TraHighestBid();
		traHighestBid.setOrderId(bidDto.getOrderId());
		traHighestBid.setCarCode(bidDto.getCarCode());
		traHighestBid.setBidType(bidDto.getBidType());
		traHighestBid.setBidWay(bidDto.getBidWay());
		traHighestBid.setMaximumPrice(bidDto.getBidAmount());
		traHighestBid.setMemberCode(String.valueOf(bidDto.getMemberCode()));
		traHighestBid.setPromisesType(bidDto.getPromisesType());//old_最高价承诺类型为自己承诺的类型
		TraHighestBid highestBid = traHighestBidMapper.getTraHighestBidByCar(traHighestBid);
		traHighestBid.setMargin(bidDto.getMargin());
		traHighestBid.setTs(bidDto.getSysDate());
		traHighestBid.setOrderNo(bidDto.getOrderNo());

		if (highestBid != null) {
			if (highestBid.getMaximumPrice() < bidDto.getBidAmount()) {
				highestBid.setTs(bidDto.getSysDate());
				highestBid.setCarCode(traHighestBid.getCarCode());
				//竞拍冻结保证金
				//如果当前最高价冻结的保证金不是当前竞价人的就解冻上一个最高价商户，冻结本次竞价商户
				if (!highestBid.getMemberCode().equals(bidDto.getMemberCode())) {
					//解冻上一拍保证金
					customerMarginUnlock(bidDto,highestBid);
					// 冻结当前会员保证金
					cusCustomerMargin(bidDto);
				}
				//如果是现场拍而且最高价类型是报价则解冻报价的保证金
				highestBid.setOrderId(bidDto.getOrderId());
				highestBid.setMaximumPrice(bidDto.getBidAmount());
				highestBid.setMemberCode(String.valueOf(bidDto.getMemberCode()));
				highestBid.setTimeliness(bidDto.getTimeliness());
				highestBid.setBidType(bidDto.getBidType());
				highestBid.setBidWay(bidDto.getBidWay());
				highestBid.setOrderNo(bidDto.getOrderNo());
				traHighestBidMapper.updateTraHighestBidByCar(highestBid);
			}
		}else {
			//最小加价幅度
			traHighestBid.setMargin(-bidDto.getFreezeAmount());
			//不是现场拍才冻结保证金
			// 冻结当前会员保证金
			cusCustomerMargin(bidDto);

			traHighestBidMapper.createTraHighestBid(traHighestBid);
		}

		Integer surplusTime = 0;
		if (Constants.BID_TYPE_BIDDING.equals(bidDto.getBidType())) {
			bidDto.setDelaySecond(Integer.parseInt(AuthorizationUtil.getInstance().getString("DELAY_SECOND")));
			// 得到订单剩余时长（秒）
			surplusTime = getOrderEndTime(bidDto, order.getAuctionModel(),order.getSurplusTime());
		}
		bidDto.setSysDate(order.getSysDate());
		// 保存报价记录
		createTraOfferWater(bidDto);
		//设置关注信息

		String tui = setCometContent(bidDto, surplusTime,order.getPlatformCosta());
		// 消息推送：最高价推送
		return tui;
	}



	/**
	 * 解冻保证金
	 * @param highestBid
	 */
	@Override
	public void customerMarginUnlock(BidVo bidDto, TraHighestBid highestBid) {
		// 解冻保证金
		CusCustomerMargin margin = new CusCustomerMargin();
		margin.setOrderId(highestBid.getOrderId());
		margin.setMemberCode(highestBid.getMemberCode());
		margin.setFreezeAmount(bidDto.getFreezeAmount());
		cusCustomerMarginMapper.updateCusCustomerMarginUnlock(margin);

		// 保存解冻保证金流水
		CusCustomerMarginWater cusCustomerMarginWater = new CusCustomerMarginWater();
		cusCustomerMarginWater.setMemberCode(highestBid.getMemberCode());
		cusCustomerMarginWater.setOperatorCash("+"+ bidDto.getFreezeAmount());
		cusCustomerMarginWater.setOperatorTime(new Date());
		cusCustomerMarginWater.setTs(highestBid.getTs());
		cusCustomerMarginWater.setOrderId(highestBid.getOrderId());
		cusCustomerMarginWater.setOrderNo(highestBid.getOrderNo());
		cusCustomerMarginWater.setCarCode(highestBid.getCarCode());
		cusCustomerMarginWater.setOperatorType(Constants.MARGIN_WATER_OPERATOR_TYPE_UNMARGIN);
		cusCustomerMarginWater.setDeleteTag(Constants.DELETE_FLAG_NO);
		cusCustomerMarginWater.setTimeliness(highestBid.getTimeliness());
		cusCustomerMarginWater.setMemo("出价被超时解冻！订单编号："+bidDto.getOrderNo()+",车辆编号：" + highestBid.getCarCode());
		cusCustomerMarginWaterMapper.createCusCustomerMarginWater(cusCustomerMarginWater);
	}


	/**
	 * 冻结保证金
	 * @param bidDto
	 */
	@Override
	public void cusCustomerMargin(BidVo bidDto) {
		// 冻结保证金
		CusCustomerMargin cusCustomerMargin = new CusCustomerMargin();
		cusCustomerMargin.setMemberCode(String.valueOf(bidDto.getMemberCode()));
		cusCustomerMargin.setFreezeAmount(bidDto.getFreezeAmount());
		cusCustomerMarginMapper.freezeCusCustomerMargin(cusCustomerMargin);

		// 保存冻结流水
		CusCustomerMarginWater customerMarginWater = new CusCustomerMarginWater();
		customerMarginWater.setMemberCode(String.valueOf(bidDto.getMemberCode()));
		customerMarginWater.setOrderId(bidDto.getOrderId());
		customerMarginWater.setCarCode(bidDto.getCarCode());
		customerMarginWater.setOperatorCash("-"+ bidDto.getFreezeAmount());
		customerMarginWater.setOperatorTime(new Date());
		customerMarginWater.setOrderNo(bidDto.getOrderNo());
		customerMarginWater.setTs(bidDto.getSysDate());
		customerMarginWater.setOperatorType(Constants.MARGIN_WATER_OPERATOR_TYPE_MARGIN);
		customerMarginWater.setDeleteTag(Constants.DELETE_FLAG_NO);
		customerMarginWater.setTimeliness(bidDto.getTimeliness());
		customerMarginWater.setMemo("出价冻结！订单编号："+bidDto.getOrderNo()+",车辆编号："+bidDto.getCarCode());
		cusCustomerMarginWaterMapper.createCusCustomerMarginWater(customerMarginWater);
	}

	/**
	 * 得到订单的结束时间，如果会员在订单结束前60秒出价，订单结束时间自动延长到还剩60秒
	 * @param bidDto
	 * @param auctionModel
	 * @param surplusTime
	 * @return
	 */
	@Override
	public Integer getOrderEndTime(BidVo bidDto, String auctionModel, Integer surplusTime) {
		Integer delaySecond = bidDto.getDelaySecond();
		// 如果小于60秒,时长延长至还剩60秒
		if (surplusTime < delaySecond) {
			TraOrderVo traOrder = new TraOrderVo();
			traOrder.setOrderId(bidDto.getOrderId());
			traOrder.setDelaySecond(delaySecond - surplusTime);
			traIndentMapper.updateTraIndentMinutes(traOrder);
			surplusTime = delaySecond - surplusTime ;
			return surplusTime;
		}
		return 0;
	}

	@Override
	public void createTraOfferWater(BidVo bidDto) {
		String dd = DateUtil.formatDate(new Date(), "yyyy/MM/dd HH:mm:ss:SSS");
		TraOfferWaterVo waterDto = new TraOfferWaterVo();
		waterDto.setOrderId(bidDto.getOrderId());
		waterDto.setCarCode(bidDto.getCarCode());
		waterDto.setMemberCode(String.valueOf(bidDto.getMemberCode()));
		waterDto.setBidAmount(bidDto.getBidAmount());
		waterDto.setBidWay(bidDto.getBidWay());
		waterDto.setAddExtent(bidDto.getAddExtent());
		waterDto.setBidType(bidDto.getBidType());
		waterDto.setPromisesType(bidDto.getPromisesType());
		waterDto.setDeleteTag(Constants.DELETE_FLAG_NO);
		waterDto.setTimeliness(bidDto.getTimeliness());
		waterDto.setOrderNo(bidDto.getOrderNo());
		traOfferWaterMapper.createTraOfferWater(waterDto);
	}

	@Override
	public String setCometContent(BidVo bidDto, Integer endsecond, Integer platformCost) {
		String orderId = "";
		if(null != bidDto.getOrderId()){
			orderId = bidDto.getOrderId();
		}
		StringBuffer content = new StringBuffer(orderId);
		content.append("|");
		content.append(bidDto.getMemberCode());
		content.append("|");
		content.append(bidDto.getBidType());
		content.append("|");
		content.append(bidDto.getBidAmount());
		content.append("|");
		content.append(bidDto.getPromisesType());
		content.append("|");
		content.append(endsecond);
		content.append("|");
		content.append(bidDto.getBidWay());
		content.append("|");
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		content.append(format.format(bidDto.getSysDate()));
		content.append("|");
		content.append(bidDto.getCarCode());
		content.append("|");
		content.append("");
		content.append("|");
		content.append(bidDto.getAddExtent());
		content.append("|");
		content.append(bidDto.getBidAmount());
		content.append("|");
		content.append(bidDto.getTimeliness());//数据有效性
		content.append("|");
		content.append(bidDto.getMemberNum());//商户编号，如：1号商户，2号商户
		content.append("|");
		content.append(bidDto.getRealName());//商户真实姓名
		return content.toString();
	}
}

