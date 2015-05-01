/**
 * 
 */
package com.skap.skapservice.service;

import com.skap.skapservice.exception.SkapServiceException;
import com.skap.skapservice.model.dto.BaseResponse;
import com.skap.skapservice.model.dto.UserDefinition;
import com.skap.skapservice.model.dto.UserDefinitionDto;
import com.skap.skapservice.model.dto.UserResponseDto;

/**
 * @author Rajesh_Mangalagiri
 *
 */
public interface SkapService {

	public UserResponseDto SaveUserDefinition(final UserDefinition userDefinition) throws SkapServiceException, Exception; 
	
	public BaseResponse updateUserDefinition(final UserDefinition userDefinition) throws SkapServiceException, Exception;
	
	public BaseResponse SaveProfilePhoto() throws SkapServiceException; 
	
	public BaseResponse getUserDetails(String userId) throws SkapServiceException;
	
	public BaseResponse validateUserID(final UserDefinitionDto userDefinitionDto) throws SkapServiceException, Exception;
	
	public BaseResponse validateLogin(final UserDefinitionDto userDefinitionDto) throws SkapServiceException, Exception;
}
