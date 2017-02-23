package com.zhh.personal.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhh.personal.base.BaseController;
import com.zhh.personal.entity.User;
import com.zhh.personal.service.UserService;

@Controller
public class UserController extends BaseController{
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "test", method = { RequestMethod.GET, RequestMethod.POST })
	public String test(@ModelAttribute("example")User user, ModelMap mm, HttpSession ses, HttpServletRequest req){
		mm.put("msg", userService.getUser().toString());
//		mm.put("msg", "你好");
		return "index";
	}
	
}
