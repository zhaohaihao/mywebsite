package com.zhh.common;

import javax.servlet.http.HttpSession;

import com.zhh.common.entity.ComSessionUser;

public class SesHelper {
	public static String COM_SESSION_USER="com_session_user";
	
	public static ComSessionUser getComSessionUser(HttpSession ses) {
		ComSessionUser userInfo = (ComSessionUser) ses.getAttribute(COM_SESSION_USER);
		return userInfo;
	}
	
	public static void setComSessionUser(HttpSession ses, ComSessionUser userInfo) {
		ses.setAttribute(COM_SESSION_USER, userInfo);
	}
	
}
