package com.zhh.personal.ctrl.contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhh.personal.ctrl.BaseCtrl;

@Controller
@RequestMapping("contact")
public class ContactCtrl extends BaseCtrl{
	
	@RequestMapping(value = "test", method = { RequestMethod.GET, RequestMethod.POST }, produces = "text/html;charset=UTF-8")
	public String test(ModelMap mm, HttpSession ses, HttpServletRequest req){
//		mm.put("msg", "你好");
		return "index";
	}
	
}
