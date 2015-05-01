/**
 * 
 */
package com.skap.skapservice.endpoint;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.skap.skapservice.exception.SkapServiceException;
import com.skap.skapservice.model.dto.BaseResponse;
import com.skap.skapservice.model.dto.UserDefinition;
import com.skap.skapservice.model.dto.UserDefinitionDto;
import com.skap.skapservice.model.dto.UserResponseDto;
import com.skap.skapservice.service.SkapService;
import com.skap.skapservice.util.ErrorCodes;
import com.skap.skapservice.util.SkapServiceConstants;
import com.skap.skapservice.util.SkapUtility;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author Rajesh_Mangalagiri
 * 
 */
@Component
@Path("/users")
@Api(value = "/users", description = "Operations on user")
public class SkapServiceEndPointImpl implements SkapServiceEndPoint,
		SkapServiceConstants {

	private static final Logger log = Logger
			.getLogger(SkapServiceEndPointImpl.class.getName());

	@Resource
	private SkapService skapService;

	@Resource
	private SkapUtility skapUtility;

	@SuppressWarnings("unused")
	@POST
	@Path("/saveUserDefinition")
	@ApiOperation(value = "saves user info into DB")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse SaveUserDefinition(
			@ApiParam(value = "user defination", required = true) final UserDefinitionDto userDefinitionDto) {

		BaseResponse baseResponse = new BaseResponse();
		log.info("In EndPoint Implementation Class- SaveUserDefinition");
		try {
			if (StringUtils.isBlank(userDefinitionDto.getUserID())
					|| StringUtils.isBlank(userDefinitionDto.getPassword())) {
				log.severe("ERROR: SkapServiceEndPointImpl.SaveUserDefinition Either UserID or Password is null");
				throw new SkapServiceException(ErrorCodes.VALIDATION_ERROR);
			}

			UserDefinition userDefinition = new UserDefinition();
			userDefinition.setUserID(userDefinitionDto.getUserID());
			userDefinition.setPassword(userDefinitionDto.getPassword());
			userDefinition.setAccountStatus(ACTIVE);
			userDefinition.setLastUpdedTime(new Date());
			userDefinition.setLastUpdatedBy(userDefinitionDto.getUserID());
			skapService.SaveUserDefinition(userDefinition);

		} catch (SkapServiceException e) {
			log.severe("ERROR: SkapServiceEndPointImpl.SaveUserDefinition"
					+ e.getMessage());
			baseResponse.setResponseCode(e.getErrorCode());
			baseResponse.setResponseMessage(e.getErrorMessage());
		} catch (Exception e) {
			log.severe("ERROR: SkapServiceEndPointImpl.SaveUserDefinition"
					+ e.getMessage());
			baseResponse.setResponseCode(ErrorCodes.GENERIC_ERROR
					.getErrorCode());
			baseResponse.setResponseMessage(ErrorCodes.GENERIC_ERROR
					.getErrorMessage());
		}
		return baseResponse;

	}

	@SuppressWarnings("unused")
	@POST
	@Path("/saveUserId")
	@ApiOperation(value = "saves user Id into DB")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse SaveUserId(
			@ApiParam(value = "user defination", required = true) final UserDefinitionDto userDefinitionDto) {

		UserResponseDto userResponseDto = new UserResponseDto();
		log.info("In EndPoint Implementation Class- SaveUserId");
		try {
			if (StringUtils.isBlank(userDefinitionDto.getUserID())) {
				log.severe("ERROR: SkapServiceEndPointImpl.SaveUserId UserID is null");
				throw new SkapServiceException(ErrorCodes.VALIDATION_ERROR);
			}
			// String activationKey = UUID.randomUUID().toString();
			String activationKey = skapUtility.ShaHexCode();
			UserDefinition userDefinition = new UserDefinition();
			userDefinition.setUserID(userDefinitionDto.getUserID());
			userDefinition.setCreatedTime(new Date());
			userDefinition.setLastUpdedTime(new Date());
			userDefinition.setCreatedBy(userDefinitionDto.getUserID());
			userDefinition.setDataAccess("S");
			userDefinition.setAKey(activationKey);
			userDefinition.setLastUpdatedBy(userDefinitionDto.getUserID());
			userDefinition.setAccountStatus(INACTIVE);
			userResponseDto = skapService.SaveUserDefinition(userDefinition);
			userResponseDto.setshaKey(activationKey);
		} catch (SkapServiceException e) {
			log.severe("ERROR: SkapServiceEndPointImpl.SaveUserId"
					+ e.getMessage());
			e.printStackTrace();
			userResponseDto.setResponseCode(e.getErrorCode());
			userResponseDto.setResponseMessage(e.getErrorMessage());
		} catch (Exception e) {
			log.severe("ERROR: SkapServiceEndPointImpl.SaveUserId"
					+ e.getMessage());
			e.printStackTrace();
			userResponseDto.setResponseCode(ErrorCodes.GENERIC_ERROR
					.getErrorCode());
			userResponseDto.setResponseMessage(ErrorCodes.GENERIC_ERROR
					.getErrorMessage());
		} finally {
			log.info("before sending the response in SaveUserId"
					+ userResponseDto.getResponseMessage());
		}
		return userResponseDto;
	}

	@POST
	@Path("/GetUserDefinition")
	@ApiOperation(value = "gets user info from DB")
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse GetUserDefinition(
			@ApiParam(value = "user defination", required = true) final UserDefinitionDto userDefinitionDto) {
		BaseResponse response = new UserResponseDto();
		log.info("User Id passed is " + userDefinitionDto.getUserID());
		try {
			if (StringUtils.isBlank(userDefinitionDto.getUserID())) {
				throw new SkapServiceException(ErrorCodes.VALIDATION_ERROR);
			}
			response = skapService
					.getUserDetails(userDefinitionDto.getUserID());
		} catch (SkapServiceException e) {
			log.severe("ERROR: SkapServiceEndPointImpl.SaveUserDefinition"
					+ e.getMessage());
			e.printStackTrace();
			response.setResponseCode(e.getErrorCode());
			response.setResponseMessage(e.getErrorMessage());
		} catch (Exception e) {
			log.severe("ERROR: SkapServiceEndPointImpl.SaveUserDefinition"
					+ e.getMessage());
			e.printStackTrace();
			response.setResponseCode(ErrorCodes.GENERIC_ERROR.getErrorCode());
			response.setResponseMessage(ErrorCodes.GENERIC_ERROR
					.getErrorMessage());
		}
		return response;
	};

	@POST
	@Path("/ValidateUserID")
	@ApiOperation(value = "gets user info from DB")
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse ValidateUserID(
			@ApiParam(value = "user defination", required = true) final UserDefinitionDto userDefinitionDto) {

		BaseResponse response = new UserResponseDto();
		log.info("In EndPoint Implementation Class- ValidateUserID");
		try {
			if (StringUtils.isBlank(userDefinitionDto.getUserID())
					|| StringUtils
							.isBlank(userDefinitionDto.getActivationKey())) {
				log.severe("User ID or Activation Key is Blank or null");
				throw new SkapServiceException(ErrorCodes.VALIDATION_ERROR);
			}
			response = skapService.validateUserID(userDefinitionDto);
		} catch (SkapServiceException e) {
			log.severe("ERROR: SkapServiceEndPointImpl.ValidateUserID"
					+ e.getMessage());
			e.printStackTrace();
			response.setResponseCode(e.getErrorCode());
			response.setResponseMessage(e.getErrorMessage());
		} catch (Exception e) {
			log.severe("ERROR: SkapServiceEndPointImpl.ValidateUserID"
					+ e.getMessage());
			e.printStackTrace();
			response.setResponseCode(ErrorCodes.GENERIC_ERROR.getErrorCode());
			response.setResponseMessage(ErrorCodes.GENERIC_ERROR
					.getErrorMessage());
		}
		log.info(response.getResponseMessage());
		return response;
	}

	@POST
	@Path("/ValidateLogin")
	@ApiOperation(value = "gets user info from DB")
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse ValidateLogin(
			@ApiParam(value = "user defination", required = true) final UserDefinitionDto userDefinitionDto) {
		BaseResponse response = new UserResponseDto();
		log.info("In EndPoint Implementation Class- ValidateLogin");
		try {
			if (StringUtils.isBlank(userDefinitionDto.getUserID())
					|| StringUtils.isBlank(userDefinitionDto.getPassword())) {
				log.severe("ERROR: SkapServiceEndPointImpl.SaveUserDefinition Either UserID or Password is null");
				throw new SkapServiceException(ErrorCodes.VALIDATION_ERROR);
			}
			response = skapService
					.getUserDetails(userDefinitionDto.getUserID());
		} catch (SkapServiceException e) {
			log.severe("ERROR: SkapServiceEndPointImpl.SaveUserDefinition"
					+ e.getMessage());
			e.printStackTrace();
			response.setResponseCode(e.getErrorCode());
			response.setResponseMessage(e.getErrorMessage());
		} catch (Exception e) {
			log.severe("ERROR: SkapServiceEndPointImpl.SaveUserDefinition"
					+ e.getMessage());
			e.printStackTrace();
			response.setResponseCode(ErrorCodes.GENERIC_ERROR.getErrorCode());
			response.setResponseMessage(ErrorCodes.GENERIC_ERROR
					.getErrorMessage());
		}
		return response;
	}

}
