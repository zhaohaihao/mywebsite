package com.personal.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoCtrl {
	
	@RequestMapping("/index")
	public String index(){
		return "demo";
	}
}
