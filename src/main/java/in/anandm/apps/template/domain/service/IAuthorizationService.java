/**
 * 
 */
package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.domain.model.permission.ModulePermissionConstants;
import in.anandm.apps.template.domain.model.permission.Permission;


/**
 * @author anandm
 *
 */
public interface IAuthorizationService {

	/**
	 * Check if the user in the current authentication context 
	 * has this {@link Permission}
	 * @param modulePermission
	 * @return
	 */
	boolean isAuthorized(ModulePermissionConstants modulePermission);
}
