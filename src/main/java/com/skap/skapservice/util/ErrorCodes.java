/**
 * 
 */
package com.skap.skapservice.util;

/**
 * @author Rajesh_Mangalagiri
 *
 */
public enum ErrorCodes {

	SUCCESS(1000,"Successfully Processed the Request"),
	GENERIC_ERROR(2000,"Generic Exception"),
	DAO_ERROR(2002,"DAO Exception"),
	VALIDATION_ERROR(2001,"Invalid Request"),
	INVALID_LOGIN(2002,"Invalid UserID/Password"),
	USER_EXISTS(2003,"User Already Exists"),
	USER_INACTIVE(2004,"User is not Active"),
	USER_INVLID(2005,"Not a VALID User");
	
	private int errorCode;
	
	private String errorMessage;

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	private ErrorCodes(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
//	
}
