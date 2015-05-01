/**
 * 
 */
package com.skap.skapservice.dao;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;

import org.springframework.stereotype.Component;

import com.skap.skapservice.exception.SkapServiceException;
import com.skap.skapservice.model.dto.UserDefinition;
import com.skap.skapservice.model.dto.UserResponseDto;
import com.skap.skapservice.util.ErrorCodes;

/**
 * @author Rajesh_Mangalagiri
 * 
 */

@Component
public class SkapServiceDaoImpl implements SkapServiceDao {

	private static final Logger log = Logger.getLogger(SkapServiceDaoImpl.class
			.getName());

	@Resource
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void saveUserDefinition(UserDefinition userDefinition)
			throws SkapServiceException, Exception {
		log.info("In DAO");
		if (null == userDefinition) {
			log.severe("ERROR: SkapServiceDaoImpl.saveUserDefinition Either UserID or Password is null");
			throw new SkapServiceException(ErrorCodes.VALIDATION_ERROR);
		}

		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		try {
			log.info("In DAO TRY");
			entityManager.getTransaction().begin();
			entityManager.setFlushMode(FlushModeType.AUTO);
			entityManager.persist(userDefinition);
			entityManager.flush();
			log.info("After Save");
		} catch (Exception e) {
			log.severe("ERROR: SkapServiceDaoImpl.saveUserDefinition DAO Exception"
					+ e.getMessage());
			e.printStackTrace();
			throw new SkapServiceException(ErrorCodes.DAO_ERROR);
		} finally {
			log.info("In Finally");
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}

	@Override
	public void saveProfilePhoto() throws SkapServiceException, Exception {

	}

	public UserDefinition getUserDetails(String userId)
			throws SkapServiceException {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		UserDefinition userDefination = null;
		try {
			log.info("In DAO TRY");
			userDefination = entityManager.find(UserDefinition.class, userId);
			log.info("After retireve");
		} catch (Exception e) {
			log.severe("ERROR: SkapServiceDaoImpl.getUserDefination DAO Exception"
					+ e.getMessage());
			e.printStackTrace();
			throw new SkapServiceException(ErrorCodes.DAO_ERROR);
		} finally {
			log.info("In Finally");
			if (entityManager.isOpen()) {
				entityManager.close();
			}
			log.info("After closing entity manager");
		}
		return userDefination;
	}

	public UserResponseDto updateUserDefinition(UserDefinition userDefinition)
			throws SkapServiceException {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		UserResponseDto userResponseDto = null;
		try {
			log.info("In DAO TRY");
			entityManager.getTransaction().begin();
			entityManager.setFlushMode(FlushModeType.AUTO);
			entityManager.merge(userDefinition);
			entityManager.getTransaction().commit();
			//entityManager.flush();
			log.info("After retireve");
		} catch (Exception e) {
			log.severe("ERROR: SkapServiceDaoImpl.updateUserDefinition DAO Exception"
					+ e.getMessage());
			e.printStackTrace();
			throw new SkapServiceException(ErrorCodes.DAO_ERROR);
		} finally {
			log.info("In Finally");
			entityManager.close();
		}
		return userResponseDto;
	}

}
