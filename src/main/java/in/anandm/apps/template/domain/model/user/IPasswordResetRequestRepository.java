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

	@Transactional(readOnly=true)
	PasswordResetRequest getPasswordResetRequestById(Long id);

	@Transactional(readOnly=true)
	List<PasswordResetRequest> getAllPasswordRequestOfUser(String userId);
	
	

}
