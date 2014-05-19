/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


/**
 * @author anandm
 *
 */
public interface IPasswordResetRequestRepository {

	@Transactional
	void savePasswordResetRequest(PasswordResetRequest passwordResetRequest);

	PasswordResetRequest getPasswordResetRequestById(Long id);

	List<PasswordResetRequest> getAllPasswordRequestOfUser(String userId);
	
	

}
