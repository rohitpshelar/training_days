package com.riomed.portal.exceptions;

public class ModuleNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModuleNotFoundException(String exMessage) {
		super(exMessage);
	}

}
