/**
 * 
 */
package com.skap.skapservice.dao;

import com.skap.skapservice.exception.SkapServiceException;
import com.skap.skapservice.model.dto.UserDefinition;
import com.skap.skapservice.model.dto.UserResponseDto;

/**
 * @author Rajesh_Mangalagiri
 *
 */
public interface SkapServiceDao {

	public void saveUserDefinition(UserDefinition userDefinition) throws SkapServiceException, Exception;
	
	public void saveProfilePhoto() throws SkapServiceException,Exception;
	
	public UserDefinition getUserDetails(String userId) throws SkapServiceException;
	
	public UserResponseDto updateUserDefinition(UserDefinition userDefinition) throws SkapServiceException;
}
