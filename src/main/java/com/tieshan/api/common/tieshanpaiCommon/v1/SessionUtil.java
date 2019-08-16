package com.tieshan.api.common.tieshanpaiCommon.v1;

import com.tieshan.api.vo.tieshanpaiVo.v1.customer.CustomerInfoVo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;


public class SessionUtil {

	public static HttpSession getSession() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
	}
	
	public static Object getSessionAttribute(String key){
		return getSession().getAttribute(key);
	}
	
	/**
	 * 获取用户编码
	 * @return
	 */
	public static String getMemberCode(){
		CustomerInfoVo info = getSessionUser();
		if(null != info){
			return info.getMemberCode();
		}else{
			return null;
		}
	}
	/**
	 * 获取用户真实姓名
	 * @return
	 */
	public static String getRealName(){
		CustomerInfoVo info = getSessionUser();
		if(null != info){
			return info.getRealName();
		}else{
			return "";
		}
	}
	/**
	 * 获取用户编号
	 * @return
	 */
	public static String getMemberNum(){
		CustomerInfoVo info = getSessionUser();
		if(null != info){
			return info.getMemberNum();
		}else{
			return null;
		}
	}
	/**
	 * 获取用户类型(0：正常用户，1：测试用户)
	 * @return
	 */
	public static String getTimeliness(){
		CustomerInfoVo info = getSessionUser();
		if(null != info){
			return info.getTimeliness();
		}else{
			return "0";
		}
	}
	/**
	 * 登录设备类型
	 * @return
	 */
	public static String getDeviceType(){
		CustomerInfoVo info = getSessionUser();
		if(null != info){
			return info.getDeviceType();
		}else{
			return null;
		}
	}
	
	public static CustomerInfoVo getSessionUser(){
		return (CustomerInfoVo)getSession().getAttribute(Constants.CUSTOMER_SESSION_INFO_NAME);
	}
	/**
	 * 等级升级后是否已提示
	 * @return
	 */
	public static String getUpgradeHinted() {
		CustomerInfoVo info = getSessionUser();
		if(null != info){
			return info.getUpgradeHinted();
		}else{
			return null;
		}
	}
	/**
	 * 会员等级
	 * @return
	 */
	public static String getGrade() {
		CustomerInfoVo info = getSessionUser();
		if(null != info){
			return info.getGrade();
		}else{
			return null;
		}
	}
}
