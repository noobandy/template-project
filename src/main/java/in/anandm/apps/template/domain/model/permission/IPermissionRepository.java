/**
 * 
 */
package in.anandm.apps.template.domain.model.permission;

import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author anandm
 *
 */
public interface IPermissionRepository {

	@Transactional
	void savePermission(Permission permission);

	@Transactional(readOnly=true)
	List<Permission> getPermissionsOfModule(String moduleName);

	@Transactional(readOnly=true)
	Permission getPermission(String moduleName,String permission);

	@Transactional(readOnly=true)
	DataTable<Permission> getDataTable(Map<String, String> params);
}
