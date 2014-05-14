/**
 * 
 */
package in.anandm.apps.template.domain.model.permission;

import in.anandm.apps.template.interfaces.web.DataTable;

import java.util.List;
import java.util.Map;

/**
 * @author anandm
 *
 */
public interface IPermissionRepository {

	void save(Permission permission);

	List<Permission> getPermissionsOfModule(String moduleName);

	DataTable<Permission> getDataTable(Map<String, String> params);
}
