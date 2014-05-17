/**
 * 
 */
package in.anandm.apps.template.interfaces.web.helper;

import in.anandm.apps.template.domain.shared.exception.ApplicationException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 * @author anandm
 *
 */
public final class HashingUtility {

	private HashingUtility(){

	}

	public static final char[] hashedPassword(String password,String salt){
		String saltAndPass = password+"{"+salt+"}";
		return hexEncodedHash(saltAndPass.getBytes(), "SHA-512");
	}

	public static final char[] hexEncodedHash(byte[] content,String hashAlgorithm){

		try {
			MessageDigest digest = MessageDigest.getInstance(hashAlgorithm);
			digest.update(content);
			return Hex.encodeHex(digest.digest());
		} catch (NoSuchAlgorithmException e) {

			throw new ApplicationException("no such algorith : "+hashAlgorithm, e);
		}



	}
}
