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

	public static final String sha512Hash(String content){

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			digest.update(content.getBytes());
			return new String(Hex.encodeHex(digest.digest()));
		} catch (NoSuchAlgorithmException e) {
			throw new ApplicationException("no such algorith : SHA-512", e);
		}



	}
}
