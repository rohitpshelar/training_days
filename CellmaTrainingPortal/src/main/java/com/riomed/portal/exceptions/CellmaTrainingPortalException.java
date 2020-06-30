package com.riomed.portal.exceptions;

public class CellmaTrainingPortalException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CellmaTrainingPortalException(String exMessage) {
		super(exMessage);
	}
	public CellmaTrainingPortalException(String exMessage, Exception e) {
		super(exMessage);
	}
}
