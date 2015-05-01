/**
 * 
 */
package skapservice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

import com.skap.skapservice.exception.SkapServiceException;
import com.skap.skapservice.util.ErrorCodes;

/**
 * @author Rajesh_Mangalagiri
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws SkapServiceException 
	 */
	public static void main(String[] args) throws SkapServiceException {
		// TODO Auto-generated method stub
		//String activationKey = UUID.randomUUID().toString();
		System.out.println("activationKey :" + hexEncode());
		
	}

	/**
	 * 
	 * Generate the unique hash code for the New Registration
	 * 
	 */
	static private String hexEncode() throws SkapServiceException {
		// initialization of the application
		SecureRandom prng;
		StringBuilder result = new StringBuilder();

		try {
			prng = SecureRandom.getInstance("SHA1PRNG");

			// generate a random number
			String randomNum = new Integer(prng.nextInt()).toString();
			System.out.println("randomNum  :" + randomNum);
			// get its digest
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			byte[] shaBytes = sha.digest(randomNum.getBytes());
			System.out.println("sha length" + shaBytes.length);
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < shaBytes.length; ++idx) {
				byte b = shaBytes[idx];
				result.append(digits[(b & 0xf0) >> 4]);
				result.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			//log.severe("ERROR: SkapServiceEndPointImpl.hexEncode"
			//		+ e.getMessage());
			throw new SkapServiceException(ErrorCodes.GENERIC_ERROR);
		}
		return result.toString();

	}
}
