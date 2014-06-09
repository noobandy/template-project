/**
 * 
 */
package in.anandm.apps.template.application.impl;

import in.anandm.apps.template.domain.helper.ISecurityContextHelper;
import in.anandm.apps.template.domain.model.authority.Authority;
import in.anandm.apps.template.domain.model.permission.ModulePermissionConstants;
import in.anandm.apps.template.domain.service.IAuthorizationService;

import java.util.Collection;

/**
 * @author anandm
 *
 */
public class AuthorizationService implements IAuthorizationService {

	private ISecurityContextHelper securityContextHelper;


	/**
	 * @param securityContextHelper
	 */
	public AuthorizationService(ISecurityContextHelper securityContextHelper) {
		super();
		this.securityContextHelper = securityContextHelper;
	}


	@Override
	public boolean isAuthorized(ModulePermissionConstants modulePermission) {

		Collection<? extends Authority> authorities = securityContextHelper.getAuthorities();

		if(authorities.isEmpty()){
			return false;
		}else{
			for (Authority authority : authorities) {
				if(authority.allowed(modulePermission.asPermission())){
					return true;
				}
			}
		}
		return false;
	}

}
