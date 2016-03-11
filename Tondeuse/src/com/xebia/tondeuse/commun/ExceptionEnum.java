package com.xebia.tondeuse.commun;



public enum ExceptionEnum {

	EXCEPTION_NON_REPERTORIEE(0, TondeuseUtils.MSG_EXCEPTION_NON_REPERTORIEE),
	
	NUMBER_FORMAT_EXCEPTION(1, TondeuseUtils.MSG_EXCEPTION_FORMAT_NOMBRE),

	FICHIER_INSTRUCTION_EXCEPTION(2, TondeuseUtils.MSG_EXCEPTION_FICHIER);
	
	private int code;
	
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private ExceptionEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public static ExceptionEnum getExceptionEnum(int code) {
		ExceptionEnum exceptionEnum = EXCEPTION_NON_REPERTORIEE;

			for (ExceptionEnum enumeration : ExceptionEnum.values()) {

				if (code == enumeration.getCode()) {

					return enumeration;
				}
			}

		return exceptionEnum;
	}


	
	
}
