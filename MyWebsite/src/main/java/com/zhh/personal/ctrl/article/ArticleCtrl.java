package com.zhh.personal.ctrl.article;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhh.personal.ctrl.BaseCtrl;
import com.zhh.personal.svs.article.IArticleSvs;

@Controller
@RequestMapping("article")
public class ArticleCtrl extends BaseCtrl{
	
	@Resource
	private IArticleSvs articleSvs;
	
	@RequestMapping(value = "test", method = { RequestMethod.GET, RequestMethod.POST }, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String test(ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			Map<String, String> reqMap = getParam(null, req);
			logger.info("params: " + reqMap);
			
			mm.put("msg", "hello");
			mm.put("sos", articleSvs.num());
			System.out.println("msg");
			
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		logger.info("res: " + JSON.toJSONString(mm));
		return JSON.toJSONString(mm);
	}
	
}
