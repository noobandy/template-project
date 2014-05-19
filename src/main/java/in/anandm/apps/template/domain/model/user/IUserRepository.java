/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import in.anandm.apps.template.interfaces.web.dto.DataTable;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author anandm
 *
 */
public interface IUserRepository {

	@Transactional
	void saveUser(User user);
	
	User getUserById(Long id);
	User getUserByUserId(String userId);
	User getUserByVerificationKey(String verificationKey);
	DataTable<User> getDataTable(Map<String, String> params);
	
}
