/**
 * 
 */
package in.anandm.apps.template.application.impl;

import in.anandm.apps.template.domain.model.permission.IPermissionRepository;
import in.anandm.apps.template.domain.model.permission.ModulePermissionConstants;
import in.anandm.apps.template.domain.model.permission.Permission;
import in.anandm.apps.template.domain.service.IPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author anandm
 *
 */
@Service
public class PermissionService implements IPermissionService {

	private IPermissionRepository permissionRepository;


	
	/**
	 * @param permissionRepository
	 */
	@Autowired
	public PermissionService(IPermissionRepository permissionRepository) {
		super();
		this.permissionRepository = permissionRepository;
	}


	@Transactional
	@Override
	public void generatePermissions() {

		for (ModulePermissionConstants modulePermissionConstants : ModulePermissionConstants.values()) {
			String moduleName = modulePermissionConstants.getModule();
			String permissionName = modulePermissionConstants.getPermission();

			Permission permission = permissionRepository.getPermission(moduleName, permissionName);

			if(permission == null){
				permissionRepository.savePermission(modulePermissionConstants.asPermission());
			}

		}
	}

}
