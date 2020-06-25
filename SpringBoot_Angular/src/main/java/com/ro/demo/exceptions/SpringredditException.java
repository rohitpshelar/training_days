package com.ro.demo.exceptions;

public class SpringRedditException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SpringRedditException(String exMessage) {
		super(exMessage);
	}
	public SpringRedditException(String exMessage, Exception e) {
		super(exMessage);
	}
}
