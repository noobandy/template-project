/**
 * 
 */
package in.anandm.apps.template.domain.model.authority;

import in.anandm.apps.template.domain.model.menu.Menu;
import in.anandm.apps.template.domain.model.permission.ModulePermissionConstants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author anandm
 * 
 */
public class Authority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String authority;
	private boolean deny;

	private Set<AuthorityPermission> authorityPermissions = new HashSet<AuthorityPermission>();
	private Set<AuthorityMenu> authorityMenus = new HashSet<AuthorityMenu>();

	/**
	 * @param authority
	 */
	public Authority(String authority) {
		super();
		this.authority = authority;
	}

	public void addAuthorityMenu(AuthorityMenu authorityMenu) {
		if (!authorityMenus.contains(authorityMenu)) {
			authorityMenus.add(authorityMenu);
		}
	}

	public void addAuthorityPermission(AuthorityPermission authorityPermission) {
		if (!authorityPermissions.contains(authorityPermission)) {
			authorityPermissions.add(authorityPermission);
		}
	}

	public void removeAuthorityMenu(AuthorityMenu authorityMenu) {
		authorityMenus.remove(authorityMenu);
	}

	public void removeAuthorityPermission(
			AuthorityPermission authorityPermission) {
		authorityPermissions.remove(authorityPermission);

	}

	public List<Menu> getValidMenus() {
		List<Menu> menus = new ArrayList<Menu>();
		long now = System.currentTimeMillis();

		for (AuthorityMenu authorityMenu : authorityMenus) {
			if (authorityMenu.getValidFrom().getTime() <= now
					&& now <= authorityMenu.getValidTill().getTime()) {
				menus.add(authorityMenu.getMenu());
			}
		}

		return menus;
	}

	public List<ModulePermissionConstants> getValidPermissions() {

		List<ModulePermissionConstants> permissionConstants = new ArrayList<ModulePermissionConstants>();
		long now = System.currentTimeMillis();

		for (AuthorityPermission authorityPermission : authorityPermissions) {
			if (authorityPermission.getValidFrom().getTime() <= now
					&& now <= authorityPermission.getValidTill().getTime()) {
				permissionConstants.add(authorityPermission
						.getModulePermissionConstant());
			}
		}

		return permissionConstants;

	}

	public boolean isDeny() {
		return deny;
	}

	public void setDeny(boolean deny) {
		this.deny = deny;
	}

	public Set<AuthorityPermission> getAuthorityPermissions() {
		return authorityPermissions;
	}

	public void setAuthorityPermissions(
			Set<AuthorityPermission> authorityPermissions) {
		this.authorityPermissions = authorityPermissions;
	}

	public Set<AuthorityMenu> getAuthorityMenus() {
		return authorityMenus;
	}

	public void setAuthorityMenus(Set<AuthorityMenu> authorityMenus) {
		this.authorityMenus = authorityMenus;
	}

	public String getAuthority() {
		return authority;
	}

	/**
	 * 
	 */
	Authority() {
		super();

	}

}
