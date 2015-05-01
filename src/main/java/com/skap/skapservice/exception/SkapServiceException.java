/**
 * 
 */
package com.skap.skapservice.exception;

import com.skap.skapservice.util.ErrorCodes;

/**
 * @author Rajesh_Mangalagiri
 *
 */

public class SkapServiceException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ErrorCodes errorCodes = ErrorCodes.GENERIC_ERROR;
	
	public SkapServiceException (final ErrorCodes errorCodes) {
		super(errorCodes.getErrorMessage());
		this.errorCodes=errorCodes;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return this.errorCodes.getErrorCode();
	}
	
	/**
	 * @return the errorCode
	 */
	public String getErrorMessage() {
		return this.errorCodes.getErrorMessage();
	}
}
