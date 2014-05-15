/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import java.util.List;

/**
 * @author anandm
 *
 */
public interface IFailedLoginRepository {

	void saveFailedLogin(FailedLogin failedLogin);
	
	List<FailedLogin> getFailedLoginofUserWithId(String userId);
}
