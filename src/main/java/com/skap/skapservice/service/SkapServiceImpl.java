/**
 * 
 */
package com.skap.skapservice.service;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.skap.skapservice.dao.SkapServiceDao;
import com.skap.skapservice.exception.SkapServiceException;
import com.skap.skapservice.model.dto.BaseResponse;
import com.skap.skapservice.model.dto.UserDefinition;
import com.skap.skapservice.model.dto.UserDefinitionDto;
import com.skap.skapservice.model.dto.UserResponseDto;
import com.skap.skapservice.util.ErrorCodes;
import com.skap.skapservice.util.SkapUtility;

/**
 * @author Rajesh_Mangalagiri
 * 
 */
@Component
public class SkapServiceImpl implements SkapService {

	private static final Logger log = Logger.getLogger(SkapServiceImpl.class
			.getName());

	private BaseResponse baseResponse;

	@Resource
	private SkapServiceDao skapServiceDao;

	@Resource
	private SkapUtility skapUtility;

	@Override
	public UserResponseDto SaveUserDefinition(UserDefinition userDefinition)
			throws SkapServiceException, Exception {
		UserResponseDto userResponseDto = new UserResponseDto();
		log.info("In Service");
		// skapServiceDao = new SkapServiceDaoImpl();
		UserDefinition user = skapServiceDao.getUserDetails(userDefinition
				.getUserID());
		log.info("After fetching the User in SaveUserDefinition");
		if (null == user || StringUtils.isBlank(user.getUserID())) {
			skapServiceDao.saveUserDefinition(userDefinition);
			log.info("In Service after DAO");
			userResponseDto.setResponseCode(ErrorCodes.SUCCESS.getErrorCode());
			userResponseDto.setResponseMessage(ErrorCodes.SUCCESS
					.getErrorMessage());
		} else {
			log.info("User already exists" + user.getUserID());
			userResponseDto.setResponseCode(ErrorCodes.USER_EXISTS
					.getErrorCode());
			userResponseDto.setResponseMessage(ErrorCodes.USER_EXISTS
					.getErrorMessage());
		}
		return userResponseDto;
	}

	@Override
	public BaseResponse SaveProfilePhoto() throws SkapServiceException {
		baseResponse = new BaseResponse();
		return baseResponse;

	}

	public BaseResponse getUserDetails(String userId)
			throws SkapServiceException {
		UserResponseDto responseDto = new UserResponseDto();
		log.info("In Service");
		// skapServiceDao = new SkapServiceDaoImpl();
		UserDefinition user = skapServiceDao.getUserDetails(userId);
		log.info("In Service after DAO");
		responseDto.setResponseCode(ErrorCodes.SUCCESS.getErrorCode());
		responseDto.setResponseMessage(ErrorCodes.SUCCESS.getErrorMessage());
		responseDto.setshaKey(user.getAKey());
		/*
		 * responseDto.setUserID(user.getUserID());
		 * responseDto.setPassword(user.getPassword());
		 * responseDto.setDataAccess(user.getDataAccess());
		 */

		return responseDto;
	}

	@Override
	public BaseResponse validateUserID(final UserDefinitionDto userDefinitionDto)
			throws SkapServiceException, Exception {
		UserResponseDto responseDto = new UserResponseDto();
		UserDefinition user = skapServiceDao.getUserDetails(userDefinitionDto
				.getUserID());
		if (userDefinitionDto.getUserID().equalsIgnoreCase(user.getUserID())
				&& userDefinitionDto.getActivationKey().equalsIgnoreCase(
						user.getAKey())) {
			log.info("In Service validateUserID: after DAO");
			responseDto.setResponseCode(ErrorCodes.SUCCESS.getErrorCode());
			responseDto
					.setResponseMessage(ErrorCodes.SUCCESS.getErrorMessage());
			String passwordKey = skapUtility.ShaHexCode();
			responseDto.setshaKey(passwordKey);
			user.setPKey(passwordKey);
			user.setLastUpdedTime(new Date());
			skapServiceDao.updateUserDefinition(user);
		} else {
			responseDto.setResponseCode(ErrorCodes.USER_INVLID.getErrorCode());
			responseDto.setResponseMessage(ErrorCodes.USER_INVLID
					.getErrorMessage());
		}
		return responseDto;
	}

	@Override
	public BaseResponse updateUserDefinition(UserDefinition userDefinition)
			throws SkapServiceException, Exception {
		baseResponse = new BaseResponse();
		log.info("In Service");
		// skapServiceDao = new SkapServiceDaoImpl();
		skapServiceDao.updateUserDefinition(userDefinition);
		log.info("In Service after DAO");
		baseResponse.setResponseCode(ErrorCodes.SUCCESS.getErrorCode());
		baseResponse.setResponseMessage(ErrorCodes.SUCCESS.getErrorMessage());
		return baseResponse;
	}

	public BaseResponse validateLogin(final UserDefinitionDto userDefinitionDto)
			throws SkapServiceException, Exception {
		UserResponseDto responseDto = new UserResponseDto();
		UserDefinition user = skapServiceDao.getUserDetails(userDefinitionDto
				.getUserID());
		String password = skapUtility.ShaHexCode(userDefinitionDto
				.getPassword() + user.getPKey());
		if (userDefinitionDto.getUserID().equalsIgnoreCase(user.getUserID())
				&& password.equalsIgnoreCase(user.getPassword())) {
			log.info("In Service validateUserID: after DAO");
			responseDto.setResponseCode(ErrorCodes.SUCCESS.getErrorCode());
			responseDto
					.setResponseMessage(ErrorCodes.SUCCESS.getErrorMessage());
			String passwordKey = skapUtility.ShaHexCode();
			responseDto.setshaKey(passwordKey);
			user.setPKey(passwordKey);
			user.setLastUpdedTime(new Date());
			skapServiceDao.updateUserDefinition(user);
		} else {
			responseDto
					.setResponseCode(ErrorCodes.INVALID_LOGIN.getErrorCode());
			responseDto.setResponseMessage(ErrorCodes.INVALID_LOGIN
					.getErrorMessage());
		}
		return responseDto;
	}

}
