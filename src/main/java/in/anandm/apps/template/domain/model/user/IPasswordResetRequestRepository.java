/**
 * 
 */
package in.anandm.apps.template.domain.model.user;


/**
 * @author anandm
 *
 */
public interface IPasswordResetRequestRepository {

	void savePasswordResetRequest(PasswordResetRequest passwordResetRequest);
	
	PasswordResetRequest getPasswordResetRequestByKey(String resetKey);

}
