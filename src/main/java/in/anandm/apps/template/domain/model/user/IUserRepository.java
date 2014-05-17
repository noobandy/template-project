/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import in.anandm.apps.template.interfaces.web.dto.DataTable;

import java.util.Map;

/**
 * @author anandm
 *
 */
public interface IUserRepository {

	void saveUser(User user);
	User getUserByUserId(String userId);
	DataTable<User> getDataTable(Map<String, String> params);
	
}
