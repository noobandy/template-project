/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import java.util.List;

/**
 * @author anandm
 *
 */
public interface ISuccessfullLoginRepository {

	void saveSuccessfullLogin(SuccessfullLogin successfullLogin);
	
	List<SuccessfullLogin> getSuccessfullLoginofUserWithId(String userId);
}
