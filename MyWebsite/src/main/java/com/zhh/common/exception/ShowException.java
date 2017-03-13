package com.zhh.common.exception;

@SuppressWarnings("serial")
public class ShowException extends BaseException {
	public ShowException() {
		super();
	}
	
	public ShowException(String msgOut) {
		super(msgOut);
	}
	
	public ShowException(String msgOut, String codeOut) {
		super(codeOut, msgOut);
	}
}
