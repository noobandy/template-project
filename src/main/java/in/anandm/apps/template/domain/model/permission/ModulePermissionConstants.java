/**
 * 
 */
package in.anandm.apps.template.domain.model.permission;

/**
 * @author anandm
 * 
 */
public enum ModulePermissionConstants {

	USER_ADD("user", "add");

	private String module;
	private String permission;

	/**
	 * @param module
	 * @param permission
	 */
	private ModulePermissionConstants(String module, String permission) {
		this.module = module;
		this.permission = permission;
	}

	public String getModule() {
		return module;
	}

	public String getPermission() {
		return permission;
	}

}
