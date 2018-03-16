package com.ggcrm.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ggcrm.core.util.ResponseUtil;
import com.ggcrm.util.NumberUtil;
import com.ggcrm.util.StringUtil;
import com.ggcrm.util.gson.JsonUtil;
import com.ggcrm.util.system.CommArray;


/**
 * 控制器基类
 * 
 */
public class BaseController {
	
	public static final String DB_ZERO = "0";
	public static final String NULL = "null";
	
	protected Log _Log = LogFactory.getLog(this.getClass());

	/**
	 * 获取Context对象
	 * @param request
	 * @param attrName
	 * @return
	 */
	protected Object getContextAttr(HttpServletRequest request, String attrName) {
		//request.getServletContext() servlet3.0添加的方法，如果直接获取会报错
		return request.getSession().getServletContext().getAttribute(attrName);
	}
	
	/**
	 * 获取项目路径
	 * @param request
	 * @return
	 */
	protected String getContextPath(HttpServletRequest request) {
		return (String) getContextAttr(request, "path");
	}
	
	/**
	 * 获取请求参数中的字符串,非null
	 * @param name
	 * @param request
	 * @return
	 */
	protected String getString(String name, HttpServletRequest request) {
		 String method = request.getMethod();  
		 name = StringUtil.toString(request.getParameter(name));
	     if("GET".equalsIgnoreCase(method)){  
	        try {
				name = new String(name.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {

			}  
	     }		
		return name;
	}
	
	/**
	 * 当参数为空时使用默认值
	 * @param name
	 * @param value
	 * @param request
	 * @return
	 */
	protected String getString(String name, String value, HttpServletRequest request) {
		 String method = request.getMethod();  
		 name = StringUtil.defaultString(request.getParameter(name), value);
	     if("GET".equalsIgnoreCase(method)){  
	        try {
				name = new String(name.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {

			}  
	     }
		return name;
	}
	
	/**
	 * 获取请求参数中的 int值
	 * @param name
	 * @param request
	 * @return
	 */
	protected int getInteger(String name, HttpServletRequest request) {
		return NumberUtil.toInt(StringUtil.defaultString(request.getParameter(name), DB_ZERO));
	}
	
	/**
	 * 获取不到使用默认值
	 * @param name
	 * @param value
	 * @param request
	 * @return
	 */
	protected int getInteger(String name, int value, HttpServletRequest request) {
		String temp = StringUtil.toString(request.getParameter(name)).trim();
		if ("".equals(temp)) {
			temp = DB_ZERO;
		}
		int result=0;
        try {
            result = Integer.parseInt(temp);
        }catch (NumberFormatException e) {}
		if (result == 0 && result != value) {
			result = value;
		}
		return result;
	}
	
	/**
	 * 输出json结果
	 * @param response
	 * @param context
	 * @throws Exception 
	 */
	protected void writeJson(HttpServletResponse response, String context) throws Exception {
		ResponseUtil.outJson(context, response);
	}
	
	/**
	 * 输出xml
	 * @param response
	 * @param context
	 * @throws Exception 
	 */
	protected void writeXml(HttpServletResponse response, String context) throws Exception {
		ResponseUtil.outXml(context, response);
	}
	
	/**
	 * 输出html
	 * @param response
	 * @param context
	 * @throws IOException
	 */
	protected void writeHtml(HttpServletResponse response, String context) throws IOException {
		ResponseUtil.outHtml(context, response);
	}	
	
	/**
	 * 设置sessionid到 attr
	 * @param name
	 * @param request
	 * @return
	 */
	protected void setSessionID(HttpServletRequest request) {
		request.setAttribute("_sessionid", request.getSession().getId());
	}
	
	/**
	 * 获取对应错误代码位置
	 * 
	 * @return
	 */
	public int getErrorIdx(String code) {
		int ret = 0;
		for (int i = 0; i < CommArray.ReturnStatus.values().length; i++) {
			if (CommArray.ReturnStatus.values()[i].equals(CommArray.ReturnStatus.valueOf("_" + code))) {
				ret = i;
				break;
			}
		}
		return ret;
	}
	
	/**
	 * 输出json文件
	 * 
	 * @param response
	 * @param xml
	 * @throws IOException
	 */
	public void outPutToJson(HttpServletResponse response, boolean result, String code)
			throws IOException {
		Map<String, String> maps = new LinkedHashMap<String, String>();
		if(result){//成功默认200
			code  = CommArray.ReturnStatus._200.toString();
		}
		// 验证失败
		int index = getErrorIdx(code);
		String xpserror = CommArray.ReturnStatus.values()[index].toString();
		String xpsmessage =CommArray.ReturnStatus.values()[index].msg;
		maps.put("code", xpserror);
		maps.put("message", xpsmessage);
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(JsonUtil.toJson(maps));
		response.getWriter().flush();
	}
	
	public static void outFile(HttpServletResponse response, byte[] b, String fileName) {
		OutputStream output = null;
		try {
			response.setHeader("Pragma","No-cache");
			response.setHeader("Cache-Control","no-cache");
			response.setDateHeader("Expires", -10);
			response.setContentType("application/octet-stream");
			response.setContentLength(b.length);
			response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
			output = response.getOutputStream();
			output.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(output!=null){
				try {
					output.flush();
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
