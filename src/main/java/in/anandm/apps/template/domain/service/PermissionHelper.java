/**
 * 
 */
package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.domain.model.authority.Authority;
import in.anandm.apps.template.domain.model.authority.IAuthorityRepository;
import in.anandm.apps.template.domain.model.menu.IMenuRepository;
import in.anandm.apps.template.domain.model.menu.Menu;
import in.anandm.apps.template.domain.model.permission.ModulePermissionConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anandm
 * 
 */
public class PermissionHelper {

	private SecurityContextHelper securityContextHelper;

	private IMenuRepository menuRepository;

	private IAuthorityRepository authorityRepository;

	/**
	 * @param securityContextHelper
	 * @param menuRepository
	 * @param authorityRepository
	 */
	public PermissionHelper(SecurityContextHelper securityContextHelper,
			IMenuRepository menuRepository,
			IAuthorityRepository authorityRepository) {
		super();
		this.securityContextHelper = securityContextHelper;
		this.menuRepository = menuRepository;
		this.authorityRepository = authorityRepository;
	}

	public boolean isAllowed(String url) {

		Menu menu = menuRepository.findMenuByURL(url);
		String[] grantedAuthorities = securityContextHelper
				.getGrantedAuthorities();

		List<Authority> authorities = authorityRepository
				.findAuthoritiesByName(grantedAuthorities);

		boolean allowed = false;
		boolean denied = false;

		for (Authority authority : authorities) {
			if (authority.getValidMenus().contains(menu)) {
				if (authority.isDeny()) {
					denied = true;
					break;
				} else {
					allowed = true;
				}
			}
		}

		return allowed & !denied;

	}

	public boolean hasPermission(
			ModulePermissionConstants modulePermissionConstant) {

		String[] grantedAuthorities = securityContextHelper
				.getGrantedAuthorities();

		List<Authority> authorities = authorityRepository
				.findAuthoritiesByName(grantedAuthorities);

		boolean allowed = false;
		boolean denied = false;

		for (Authority authority : authorities) {
			if (authority.getValidPermissions().contains(
					modulePermissionConstant)) {
				if (authority.isDeny()) {
					denied = true;
					break;
				} else {
					allowed = true;
				}
			}
		}

		return allowed & !denied;
	}

	public List<ModulePermissionConstants> allowedPermissions(String moduleName) {

		String[] grantedAuthorities = securityContextHelper
				.getGrantedAuthorities();

		List<Authority> authorities = authorityRepository
				.findAuthoritiesByName(grantedAuthorities);

		List<ModulePermissionConstants> allowedPermissions = new ArrayList<ModulePermissionConstants>();

		for (Authority authority : authorities) {
			if (!authority.isDeny()) {
				for (ModulePermissionConstants modulePermissionConstant : authority
						.getValidPermissions()) {
					if (modulePermissionConstant.getModule().equals(moduleName)) {
						allowedPermissions.add(modulePermissionConstant);
					}
				}
			}

		}

		return allowedPermissions;

	}
}
