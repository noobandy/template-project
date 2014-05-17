/**
 * 
 */
package in.anandm.apps.template.domain.service;

import org.springframework.stereotype.Service;

/**
 * @author anandm
 *
 */
@Service
public class EmailService implements IEmailService {

	@Override
	public void sendAccountVerificationEmail(String emailId,
			String verificationKey) {
	}

	@Override
	public void sendPasswordResetEmail(String emailid, String passwordResetKey) {
	}

}
