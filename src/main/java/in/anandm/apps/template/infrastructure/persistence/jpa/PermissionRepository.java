/**
 * 
 */
package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.permission.IPermissionRepository;
import in.anandm.apps.template.domain.model.permission.Permission;
import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

/**
 * @author anandm
 *
 */
@Repository
public class PermissionRepository extends BaseRepository<Permission, Long> implements
IPermissionRepository {


	public void savePermission(Permission permission){

		save(permission);
	}

	@Override
	public List<Permission> getPermissionsOfModule(String moduleName) {

		Search search = new Search(Permission.class);
		search.addFilter(Filter.equal("moduleName", moduleName));
		search.setResultMode(Search.RESULT_LIST);

		return search(search);
	}

	@Override
	public Permission getPermission(String moduleName, String permission) {

		Search search = new Search(Permission.class);
		Filter moduleNameFilter = Filter.equal("moduleName", moduleName);
		Filter permissionNameFilter = Filter.equal("permissionName", permission);
		Filter permissionFilter = Filter.and(moduleNameFilter,permissionNameFilter);
		search.addFilter(permissionFilter);

		search.setResultMode(Search.RESULT_SINGLE);

		return searchUnique(search);
	}

	@Override
	public DataTable<Permission> getDataTable(Map<String, String> params) {

		return getDataTable(params);
	}


}
