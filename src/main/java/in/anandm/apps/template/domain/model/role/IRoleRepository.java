/**
 * 
 */
package in.anandm.apps.template.domain.model.role;

import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.Map;

/**
 * @author anandm
 *
 */
public interface IRoleRepository {

	void save(Role role);
	Role getRoleByRoleName(String roleName);
	DataTable<Role> getDataTable(Map<String, String> params);
}
