package com.ggcrm.util.system;

import java.util.HashMap;
import java.util.Map;

/**
 * 信息模板
 * @author Administrator
 *
 */
public class MsgTemplate {

	public static Map<Integer,String> templates = new HashMap<Integer,String>();
	
	/*
	 * 姓名后面要带上（先生/女士）
	 * */
	static{
		templates.put(1, "广购CRM验证邮件");
		templates.put(2, "尊敬的用户%s，<a href='%s'>点击链接即可完成注册</a>");
		templates.put(3, "激活你的电子邮箱账号");
		templates.put(4, "广购CRM");
		templates.put(5, "广购用户安全验证");
		templates.put(6, "亲爱的广购用户%s，您好！<br/><br/>您的验证码是：%s<br/>此验证码将用于验证身份，修改密码密保等。请勿将验证码透露给其他人。<br/><br/>本邮件由系统自动发送，请勿直接回复！<br/>感谢您的访问，祝您使用愉快");
	}
	
	public static final String _01 = templates.get(1);//邮箱注册发送的验证邮件标题
	
	public static final String _02 = templates.get(2);//邮箱注册发送的验证邮件内容
	
	public static final String _03 = templates.get(3);
	
	public static final String _04 = templates.get(4);
	
	public static final String _05 = templates.get(5);
	
	public static final String _06 = templates.get(6);
}
