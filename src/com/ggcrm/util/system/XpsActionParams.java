package com.ggcrm.util.system;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.ggcrm.util.NumberUtil;
import com.ggcrm.util.StringUtil;

/**
 * XPS客户端调用参数
 * 
 * @author liangyi
 * 
 */
public class XpsActionParams {
	//private static final Log _Log = LogFactory.getLog(XpsActionParams.class);
	public final String agent; // 手机/终端型号
	public final String id; // 手机（终端）唯一标识号、IMEI或IMSI等
	public final String action; // 执行的动作
	public final DeviceInfo device; // DeviceInfo
	public final String xps_usertoken; //用戶端標識名
	public final String xps_username; //xps使用者或聯通oa使用者
	public final String xps_userpwd; //xps使用者密碼
	public final int xps_usertype;//登录了性
	public final String xps_deviceos;
	public final String xps_brower;
	public final String xps_uuid;
	public final int xps_logintype;
	public final String xps_pushtoken;//友盟DeviceToken
	public final String xps_enterprisetoken; //用戶端標識名
	public final String xps_headimgurl;//微信头像
	public final String Origin;
	public final String xps_smssign;//短信签名
	
	public XpsActionParams(HttpServletRequest request) throws UnsupportedEncodingException {
		this.agent = StringUtil.toString(request.getHeader("user-agent"));

		String s = StringUtil.toString(request.getHeader("XPS-Action"));
		this.action = (s.length() > 0) ? s : StringUtil.toString(request.getParameter("XPS-Action"));

		s = StringUtil.toString(request.getHeader("XPS-ID"));
		this.id = (s.length() > 0) ? s : StringUtil.toString(request.getParameter("XPS-ID"));
		
		String hostUrl = request.getRequestURL().toString();
		int idx = hostUrl.indexOf('/', 8);
		if (-1 == idx) {
			hostUrl = "http://" + request.getHeader("host") + "/";
		} else {
			hostUrl = hostUrl.substring(0, idx + 1);
		}
		this.device = new DeviceInfo(agent, request.getHeader("Accept-Language"), hostUrl);
		//XPS-Token：token
		s = StringUtil.toString(request.getHeader("XPS-Usertoken"));
		s = (s.length() > 0) ? s : StringUtil.toString(request.getParameter("XPS-Usertoken"));
		if(null != s && s.length()>0){
			this.xps_usertoken = s;
		}else{
			this.xps_usertoken = "";
		}
		//XPS-Username：企業帳號
		s = StringUtil.toString(request.getHeader("XPS-Username"));
		this.xps_username = (s.length() > 0) ? s : StringUtil.toString(request.getParameter("XPS-Username"));
		//XPS-Password：MD5(認證密碼)
		s = StringUtil.toString(request.getHeader("XPS-Password"));
		this.xps_userpwd = (s.length() > 0) ? s : StringUtil.toString(request.getParameter("XPS-Password"));
		//XPS-Usertype
		s = StringUtil.toString(request.getHeader("XPS-Usertype"));
		this.xps_usertype = (s.length() > 0) ? NumberUtil.toInt(s) : NumberUtil.toInt(request.getParameter("XPS-Usertype"));
		//XPS-Deviceos
		s = StringUtil.toString(request.getHeader("XPS-Deviceos"));
		this.xps_deviceos = (s.length() > 0) ? s : StringUtil.toString(request.getParameter("XPS-Deviceos"));
		//XPS-Brower
		s = StringUtil.toString(request.getHeader("XPS-Brower"));
		this.xps_brower = (s.length() > 0) ? s : StringUtil.toString(request.getParameter("XPS-Brower"));
		//XPS-Uuid
		s = StringUtil.toString(request.getHeader("XPS-Uuid"));
		this.xps_uuid = (s.length() > 0) ? s : StringUtil.toString(request.getParameter("XPS-Uuid"));
		//XPS-Logintype
		s = StringUtil.toString(request.getHeader("XPS-Logintype"));
		this.xps_logintype = (s.length() > 0) ? NumberUtil.toInt(s) : NumberUtil.toInt(request.getParameter("XPS-Logintype"));
		//XPS_Pushtoken
		s = StringUtil.toString(request.getHeader("XPS-Pushtoken"));
		this.xps_pushtoken = (s.length() > 0) ? s : StringUtil.toString(request.getParameter("XPS-Pushtoken"));
		//XPS-Token：token
		s = StringUtil.toString(request.getHeader("XPS-Enterprisetoken"));
		s = (s.length() > 0) ? s : StringUtil.toString(request.getParameter("XPS-Enterprisetoken"));
		if(null != s && s.length()>0){
			this.xps_enterprisetoken = s;
		}else{
			this.xps_enterprisetoken = "";
		}
		s = StringUtil.toString(request.getHeader("XPS-Headimgurl"));
		this.xps_headimgurl = (s.length() > 0) ? s : StringUtil.toString(request.getParameter("XPS-Headimgurl"));
		s = StringUtil.toString(request.getHeader("Origin"));
		this.Origin = s;
		s = StringUtil.toString(request.getHeader("XPS-Smssign"));
		this.xps_smssign = (s.length() > 0) ? s : StringUtil.toString(request.getParameter("XPS-Smssign"));
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
