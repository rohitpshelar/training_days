package com.ro.demo.exceptions;

public class SpringredditException extends RuntimeException {
	
	public SpringredditException(String exMessage) {
		super(exMessage);
	}
	public SpringredditException(String exMessage, Exception e) {
		super(exMessage);
	}
}
