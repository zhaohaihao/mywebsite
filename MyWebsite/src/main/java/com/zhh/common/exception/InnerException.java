package com.zhh.common.exception;

@SuppressWarnings("serial")
public class InnerException extends BaseException {
	public InnerException() {
		super();
	}
	
	public InnerException(String msgOut) {
		super(msgOut);
	}
	
	public InnerException(String msgOut, String codeOut) {
		super(codeOut, msgOut);
	}
}
