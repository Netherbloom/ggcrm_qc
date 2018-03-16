package com.ggcrm.util.system;

/**
 * 终端信息
 * 
 * User-Agent：<手机/终端型号>/<企业号>/<软件版本号> (<终端操作系统>;<终端操作系统版本号>;<屏幕尺寸>)
 * 
 * 如“Dopod S1/1 (wm;2006;240x320)”
 * 
 * Accept-Language：客户端接受的语言 如“Accept-Language: zh-cn”
 * 
 * @author liangyi
 * 
 */
public class DeviceInfo {
	public final String model; // 手机/终端型号
	public final String version; // 软件版本号
	public final String os; // 终端操作系统
	public final String osVersion; // 终端操作系统版本号
	public final String screenSize; // 屏幕尺寸
	public final String picSize;//图片尺寸
	public final String language; // 语言
	public final String hostUrl; // 访问入口的URL根路径

	public DeviceInfo(String model, String version, String os, String osVersion, String screenSize,String picSize,
			String language, String hostUrl) {
		this.model = model;
		this.version = version;
		if(os != null && os.length() > 0 && os.equals(CommArray.DeviceType.ios.getName())){
			this.os = CommArray.DeviceType.iphone.getName();
		}else{
			this.os = os;
		}
		this.osVersion = osVersion;
		this.screenSize = screenSize;
		this.picSize = picSize;
		this.language = language;
		this.hostUrl = hostUrl;
	}

	public DeviceInfo(String userAgent, String acceptLanguage, String hostUrl) {
		this.language = acceptLanguage;
		String v = "", o = "", ov = "", ss = "",ps="";

		int idx = userAgent.indexOf('/');
		if (-1 == idx) {
			this.model = userAgent;
		} else {
			this.model = userAgent.substring(0, idx);
			userAgent = userAgent.substring(idx + 1);
			idx = userAgent.indexOf('(');
			if (-1 == idx) {
				v = userAgent;
			} else {
				v = userAgent.substring(0, idx).trim();
				userAgent = userAgent.substring(idx + 1);
				idx = userAgent.lastIndexOf(')');
				if (-1 != idx) {
					userAgent = userAgent.substring(0, idx);
				}
				String[] strs = userAgent.split("\\;");
				if (strs.length > 0) {
					o = strs[0].trim();
				}
				if (strs.length > 1) {
					ov = strs[1].trim();
				}
				if (strs.length > 2) {
					ss = strs[2].trim();
				}
				if (strs.length > 3) {
					ps = strs[3].trim();
				}
			}
		}
		this.version = v;
		if(o != null && o.length() > 0 && o.equals(CommArray.DeviceType.ios.getName())){
			this.os = CommArray.DeviceType.iphone.getName();
		}else{
			this.os = o;
		}
		this.osVersion = ov;
		this.screenSize = ss;
		this.picSize = ps;
		this.hostUrl = hostUrl;
	}

	public String toString() {
		return model + '/' + version + " (" + os + "; " + osVersion + "; " + screenSize + "; " + language + ")";
	}	
}
