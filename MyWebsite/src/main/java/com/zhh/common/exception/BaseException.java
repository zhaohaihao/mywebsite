package com.zhh.common.exception;

@SuppressWarnings("serial")
public class BaseException extends RuntimeException {
	private String code = "E";
	private String msg = "程序异常";
	
	public BaseException() {
		super();
	}
	public BaseException(String msg) {
		super(msg);
		this.msg = msg;
	}
	public BaseException(String code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
