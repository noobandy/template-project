/**
 * 
 */
package in.anandm.apps.template.domain.model.authority;

import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.Map;

/**
 * @author anandm
 *
 */
public interface IAuthorityRepository {

	void save(Authority role);
	Authority getRoleByRoleName(String roleName);
	DataTable<Authority> getDataTable(Map<String, String> params);
}
