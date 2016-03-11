package com.xebia.tondeuse.commun;


public class TondeuseException extends RuntimeException {

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = 1L;

	public TondeuseException(int code, String message) {

		super(ExceptionEnum.getExceptionEnum(code).getMessage() + message);

	}

}
