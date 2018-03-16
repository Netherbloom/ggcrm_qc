package com.ggcrm.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggcrm.web.controller.BaseController;

/****
 * 公共页面处理
 * @author Stanley(PyePye)
 */

@Controller
public class CommonController extends BaseController {
		
	/**
	 * 出错处理-404
	 * @param request 传入http请求值
	 * @return
	 */
	@RequestMapping("/nofind")  
	public String NoFind(HttpServletRequest request) {
		//_Log.info("文件找不到");
		return "nofind";
	}
	
	
	/**
	 * 出错处理-500
	 * @param request 传入http请求值
	 * @return
	 */
	@RequestMapping("/error")  
	public String error(HttpServletRequest request) {
		//_Log.info("文件找不到");
		return "error";
	}	
}
