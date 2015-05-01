/**
 * 
 */
package com.skap.skapservice.endpoint;

import com.skap.skapservice.model.dto.BaseResponse;
import com.skap.skapservice.model.dto.UserDefinitionDto;
import com.skap.skapservice.model.dto.UserResponseDto;

/**
 * @author Rajesh_Mangalagiri
 *
 */
public interface SkapServiceEndPoint {

	public BaseResponse SaveUserDefinition(final UserDefinitionDto userDefinitionDto);
	
	public BaseResponse SaveUserId(final UserDefinitionDto userDefinitionDto);
	
	public BaseResponse GetUserDefinition(final UserDefinitionDto userDefinitionDto);
	
	public BaseResponse ValidateUserID(final UserDefinitionDto userDefinitionDto);
	
	public BaseResponse ValidateLogin(final UserDefinitionDto userDefinitionDto);
}
