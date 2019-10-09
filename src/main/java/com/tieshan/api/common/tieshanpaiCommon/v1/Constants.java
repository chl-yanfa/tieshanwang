package com.tieshan.api.common.tieshanpaiCommon.v1;

public class Constants {
	
	
	public final static String RETURN_CODE_SYSTEM_FAIL       = "200000";// 系统错误
	public final static String RETURN_MSG_SYSTEM_FAIL    = "操作失败";
	public final static String RETURN_CODE_SUCCESS           = "000000";// 成功
	public final static String RETURN_CODE_SUCCESS1           = "000001";// 成功
	public final static String RETURN_MSG_SUCCESS        = "操作成功";// 成功
	public final static String RETURN_CODE_DATA_NULL         = "400000";// 数据为空
	public final static String RETURN_MSG_DATA_NULL      = "数据为空";//数据为空
	public final static String RETURN_CODE_PASS_ERROR        = "000002";// 账号或密码错误
	public final static String RETURN_CODE_CODE_ERROR        = "000004";//
	public final static String RETURN_CODE_PHONE_ERROR        = "000005";
	public final static String RETURN_CODE_KAPTCHA_ERROR     = "000003";// 验证码错误
	public final static String NO_AUTH_PEOPLE = "200001";	//未实名认证
	/** 正常登录  */
	public final static String MERCHANTS_FORCE_LOGIN_NORMAL = "0";
	
	
	public final static String DELETE_YES = "1";//删除
	public final static String DELETE_NO = "0";//未删除
	
	
	
	/** 参拍模式-所有参拍模式*/
	public final static String AUCTION_MODEL_ALL = "1234";
	/** 参拍模式-即时拍+长时拍 */
	public final static String AUCTION_MODEL_J_C = "0";
	
	
	
	//删除标示
	public final static String DELETE_FLAG_YES = "1";//已删除
	public final static String DELETE_FLAG_NO = "0";//未删除
	
	/** 关注 */
	public final static String CUSTOMER_ATTENTION_YES = "1";
	/** 取消关注 */
	public final static String CUSTOMER_ATTENTION_NO = "0";
	/** 关注来源-关注 */
	public final static String SOURCE_ATTENTION = "0"; //关注
	
	/** 存储会员信息的session名称 */
	public final static String CUSTOMER_SESSION_INFO_NAME = "customerInfo";
	/** 存储会员信息的cookie名称 */
	public final static String CUSTOMER_SESSION_INFO_NAME_COOKIE = "customerInfo_C";
	public final static String CUSTOMER_SESSION_INFO_NAME_COOKIE2 = "customerInfo_N";
	
	/** 登录设备-PC  */
	public final static String DEVICE_TYPE_PC = "1";
	
	/** 您的出价金额不能为空。 */
	public final static String PRICE_NOT_NULL="800020";
	/** 当前订单状态，不支持此次出价方式 */
	public final static String QUOTEPRICE_NOT_SUPPORT = "800010";
	/** 您的出价不合法。 */
	public final static String PRICE_ERROR="800030";
	public final static String RETURN_CODE_PARAMETER_NULL    = "100000";// 参数为空（输入参数数据）
	
	/** 您的保证金余额不足，请充值。 */
	public final static String MARGIN_LESS="800080";
	
	/** 出价类型-竞价*/
	public final static String BID_TYPE_BIDDING = "0";
	
//	public final static String ORDER_STATUS_AUCTIONING   =  "20"; //竞拍中
	public final static String ORDER_STATUS_AUCTIONING   =  "4";
	
	/** 承诺类型-不限 */
	public final static String PROMISES_TYPE_UNLIMITED = "2";
	
	/** 当前报价过低 */
	public final static String PRICE_VERY_LOW="800130";
	
	/** 未达到最小加价幅度 */
	public final static String NOT_SMALLEST_INCREASE ="800180";
	
	/** 报价或竞价未开始*/
	public final static String NOT_START = "800060";
	/** 报价或竞价已结束*/
	public final static String ENDED = "800070";
	
	/** 流水操作类型-冻结保证金*/
	public final static String MARGIN_WATER_OPERATOR_TYPE_MARGIN = "1";
	/** 流水操作类型 -解冻保证金*/
	public final static String MARGIN_WATER_OPERATOR_TYPE_UNMARGIN = "2";
	/** 流水操作类型 -违约扣除*/
	public final static String MARGIN_WATER_OPERATOR_TYPE_DEDUCTION = "3";
	/** 流水操作类型 -财务退款*/
	public final static String MARGIN_WATER_OPERATOR_TYPE_FINANCIAL_REFUNDS = "5";
	/** 流水操作类型 -财务扣款*/
	public final static String MARGIN_WATER_OPERATOR_TYPE_FINANCIAL_AFFAIRS = "6";
	/** 流水操作类型 -冻结+违约扣除*/
	public final static String MARGIN_WATER_OPERATOR_TYPE_FROZEN_DEDUCTION = "13";
	
	/** 出价-推送时使用 */
	public final static String COMET_TYPE_NEWPRICE = "newprice";

	/**
	 * ScrapOrderStatus 报废订单状态
	 */
	public static final class ScrapOrderStatus{
		/**SCRAP_CAR 整车  1 */
		public static final Integer SCRAP_CAR = 1;
		/**SCRAP_AUTOPARTS 旧件  2 */
		public static final Integer SCRAP_AUTOPARTS = 2;
		/**CAR_FINISH 整车:已完成 7 */
		public static final Integer CAR_FINISH = 7;
		/**AUTOPARTS_FINISH 旧件:已完成 8 */
		public static final Integer AUTOPARTS_FINISH = 8;
		/**ORDER_AUCTION 拍卖  91 */
		public static final Integer ORDER_AUCTION = 91;
		/**ORDER_DEL_AUCTION 删除拍品  92 */
		public static final Integer ORDER_DEL_AUCTION = 92;
	}

	/**
	 * OrderStatus 订单状态
	 */
	public static final class OrderStatus{
		/**HAS_NOT_AUCTION 未上拍 0 */
		public static final String HAS_NO_AUCTION = "0";
		/**TO_AUCTION 待竞拍 10 */
		public static final String TO_AUCTION = "10";
		/**COMPETE 竞拍中 20 */
		public static final String COMPETE = "20";
		/**TO_COMPETE 待处理 30*/
		public static final String TO_COMPETE = "30";
		/**TO_SETTLE 待付款 50*/
		public static final String TO_SETTLE = "50";
		/**TO_ABORTIVE 流拍 40*/
		public static final String TO_ABORTIVE = "40";
		/**TO_TAKECAR 待提货 60*/
		public static final String TO_TAKECAR = "60";
		/**TO_TRANSFER 待过户 70*/
		public static final String TO_TRANSFER = "70";
		/**TRANSFERED 已过户 71*/
		public static final String TRANSFERED = "71";
		/**FINISHED 已完成 80*/
		public static final String FINISHED = "80";
		/**DUPLICATE_AUCTION 已复拍 -8*/
		public static final String DUPLICATE_AUCTION = "-8";
		/**OVERTURN_AUCTION 已撤拍 -9*/
		public static final String OVERTURN_AUCTION = "-9";
		/**RETURNCAR_AUCTION 已退货 -10*/
		public static final String RETURNCAR_AUCTION = "-10";
	}
}
