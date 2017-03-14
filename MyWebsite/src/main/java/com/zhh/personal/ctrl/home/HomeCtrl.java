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
@RequestMapping("home")
public class HomeCtrl extends BaseCtrl{
	
	@RequestMapping(value = "test", method = { RequestMethod.GET, RequestMethod.POST })
	public String test(ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			Map<String, String> reqMap = getParam(null, req);
			logger.info("params: " + reqMap);
			
			mm.put("msg", "hello");
			
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "index";
	}
	
	@RequestMapping(value = "test1", method = { RequestMethod.GET, RequestMethod.POST })
	public String test1(ModelMap mm, HttpSession ses, HttpServletRequest req){
//		mm.put("msg", "你好");
		return "gallery";
	}
	
	@RequestMapping(value = "test2", method = { RequestMethod.GET, RequestMethod.POST })
	public String test2(ModelMap mm, HttpSession ses, HttpServletRequest req){
//		mm.put("msg", "你好");
		return "article";
	}
	
	@RequestMapping(value = "test3", method = { RequestMethod.GET, RequestMethod.POST })
	public String test3(ModelMap mm, HttpSession ses, HttpServletRequest req){
//		mm.put("msg", "你好");
		return "contact";
	}
}
