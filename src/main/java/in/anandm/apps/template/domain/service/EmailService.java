/**
 * 
 */
package in.anandm.apps.template.domain.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * @author anandm
 *
 */
@Service
public class EmailService implements IEmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;


	@Override
	public void sendAccountVerificationEmail(final String userId,final String emailId,
			String verificationKey) {
		LoggerFactory.getLogger(getClass()).info("sending email... emailId : {}, vereficationKey : {}",emailId,verificationKey);
		final Map<String, Object> mailModel = new HashMap<String, Object>();
		mailModel.put("userId", userId);
		mailModel.put("verificationKey", verificationKey);
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(emailId);
				message.setFrom("noobandy1364@gmail.com");
				message.setSubject("Account Verification");

				String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "accountVerification.vm", "utf8", mailModel);

				message.setText(body, true);
			}
		};

		mailSender.send(preparator);
	}

	@Override
	public void sendPasswordResetEmail(final Long requestId,final String emailId,final String passwordResetKey) {
		LoggerFactory.getLogger(getClass()).info("sending email... emailId : {}, resteKey : {}",emailId,passwordResetKey);

		final Map<String, Object> mailModel = new HashMap<String, Object>();
		mailModel.put("requestId", requestId);
		mailModel.put("passwordResetKey", passwordResetKey);
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(emailId);
				message.setFrom("noobandy1364@gmail.com");
				message.setSubject("Account Verification");

				String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "passwordReset.vm", "utf8", mailModel);

				message.setText(body, true);
			}
		};

		mailSender.send(preparator);
	}

}
