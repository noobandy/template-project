/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author anandm
 *
 */
public interface IUserRepository {

	@Transactional
	void saveUser(User user);

	@Transactional(readOnly=true)
	User getUserById(Long id);

	@Transactional(readOnly=true)
	User getUserByUserId(String userId);

	@Transactional(readOnly=true)
	User getUserByVerificationKey(String verificationKey);

	@Transactional(readOnly=true)
	DataTable<User> getDataTable(Map<String, String> params);

}
