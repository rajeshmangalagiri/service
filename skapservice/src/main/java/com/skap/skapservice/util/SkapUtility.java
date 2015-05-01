/**
 * 
 */
package com.skap.skapservice.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.skap.skapservice.exception.SkapServiceException;

/**
 * @author Rajesh_Mangalagiri
 *
 */
@Component
public class SkapUtility {
	
	private static final Logger log = Logger
			.getLogger(SkapUtility.class.getName());

	/**
	 * 
	 * Generate the unique hash code for the New Registration
	 * 
	 */
	public static String ShaHexCode() throws SkapServiceException {
		// initialization of the application
		SecureRandom prng;
		StringBuilder result = new StringBuilder();

		try {
			prng = SecureRandom.getInstance("SHA1PRNG");
			// generate a random number
			String randomNum = new Integer(prng.nextInt()).toString();
			// get its digest
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] shaBytes = sha.digest(randomNum.getBytes());

			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < shaBytes.length; ++idx) {
				byte b = shaBytes[idx];
				result.append(digits[(b & 0xf0) >> 4]);
				result.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			log.severe("ERROR: SkapServiceEndPointImpl.ShaHexCode"
					+ e.getMessage());
			throw new SkapServiceException(ErrorCodes.GENERIC_ERROR);
		}
		return result.toString();

	}

	/**
	 * 
	 * Generate the unique hash code for the New Registration
	 * 
	 */
	public static String ShaHexCode(String value) throws SkapServiceException {
		// initialization of the application
		StringBuilder result = new StringBuilder();

		try {
			// get its digest
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] shaBytes = sha.digest(value.getBytes());

			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < shaBytes.length; ++idx) {
				byte b = shaBytes[idx];
				result.append(digits[(b & 0xf0) >> 4]);
				result.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			log.severe("ERROR: SkapServiceEndPointImpl.ShaHexCode"
					+ e.getMessage());
			throw new SkapServiceException(ErrorCodes.GENERIC_ERROR);
		}
		return result.toString();

	}

}
