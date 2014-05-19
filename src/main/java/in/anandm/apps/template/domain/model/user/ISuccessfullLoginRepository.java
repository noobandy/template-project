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
public interface ISuccessfullLoginRepository {

	@Transactional
	void saveSuccessfullLogin(SuccessfullLogin successfullLogin);

	List<SuccessfullLogin> getSuccessfullLoginofUserWithId(String userId);
}
