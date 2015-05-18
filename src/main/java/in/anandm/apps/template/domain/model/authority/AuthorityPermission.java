/**
 * 
 */
package in.anandm.apps.template.domain.model.authority;

import in.anandm.apps.template.domain.model.permission.ModulePermissionConstants;

import java.io.Serializable;
import java.util.Date;

/**
 * @author anandm
 * 
 */
public class AuthorityPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ModulePermissionConstants modulePermissionConstant;
	private Date validFrom;
	private Date validTill;

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTill() {
		return validTill;
	}

	public ModulePermissionConstants getModulePermissionConstant() {
		return modulePermissionConstant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((modulePermissionConstant == null) ? 0
						: modulePermissionConstant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AuthorityPermission other = (AuthorityPermission) obj;
		if (modulePermissionConstant != other.modulePermissionConstant) {
			return false;
		}
		return true;
	}

}
