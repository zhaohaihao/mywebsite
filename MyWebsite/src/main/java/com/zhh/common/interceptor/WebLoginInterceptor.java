package com.zhh.common.interceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.zhh.common.SesHelper;
import com.zhh.common.annotation.WebLoginTag;
import com.zhh.common.entity.ComSessionUser;

/**
 * 登陆拦截器
 * @date 2017-3-13 下午4:30:55
 * @author zhaohaihao
 */
public class WebLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		WebLoginTag annotation = method.getAnnotation(WebLoginTag.class);
		if (annotation != null)	{
			if (!annotation.needLogin()) {
				return true;
			}
			ComSessionUser user = SesHelper.getComSessionUser(request.getSession());
			if (user == null) {
				// 去登陆界面
				Map<String, String> map = new HashMap<String, String>();
				map.put("code", "E");
				map.put("error", "页面已失效,请重登陆");
				request.getRequestDispatcher("/index").forward(request, response);
				response.getWriter().write(JSON.toJSONString(map));
				return false;
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
}
