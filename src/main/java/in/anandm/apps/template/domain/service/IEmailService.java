/**
 * 
 */
package in.anandm.apps.template.domain.service;

/**
 * @author anandm
 *
 */
public interface IEmailService {

	void sendAccountVerificationEmail(String emailId,String verificationKey);
	void sendPasswordResetEmail(String emailid,String passwordResetKey);
}
