package com.zhh.personal.ctrl.home;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhh.personal.ctrl.BaseCtrl;

@Controller
public class HomeCtrl extends BaseCtrl{
	
	@RequestMapping(value = "home", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			Map<String, String> reqMap = getParam(null, req);
			logger.info("params: " + reqMap);	// 获得所有请求来的参数
			
			
			
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "index";
	}
	
}
