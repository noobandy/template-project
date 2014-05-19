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
public interface IFailedLoginRepository {

	@Transactional
	void saveFailedLogin(FailedLogin failedLogin);
	
	List<FailedLogin> getFailedLoginofUserWithId(String userId);
}
