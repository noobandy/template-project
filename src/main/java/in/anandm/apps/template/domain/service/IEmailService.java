/**
 * 
 */
package in.anandm.apps.template.domain.service;

/**
 * @author anandm
 *
 */
public interface IEmailService {

	void sendAccountVerificationEmail(String userId,String emailId,String verificationKey);
	void sendPasswordResetEmail(Long requestId,String emailid,String passwordResetKey);
}
