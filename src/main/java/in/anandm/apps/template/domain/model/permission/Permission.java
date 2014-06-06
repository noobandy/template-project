/**
 * 
 */
package in.anandm.apps.template.domain.model.permission;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author anandm
 *
 */
@Entity
public class Permission {

	private String permissionName;
	private String moduleName;


	/**
	 * @param permissionName
	 * @param moduleName
	 */
	public Permission(String permissionName, String moduleName) {
		super();
		this.permissionName = permissionName;
		this.moduleName = moduleName;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public String getModuleName() {
		return moduleName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((moduleName == null) ? 0 : moduleName.hashCode());
		result = prime * result
				+ ((permissionName == null) ? 0 : permissionName.hashCode());
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
		Permission other = (Permission) obj;
		if (moduleName == null) {
			if (other.moduleName != null) {
				return false;
			}
		} else if (!moduleName.equals(other.moduleName)) {
			return false;
		}
		if (permissionName == null) {
			if (other.permissionName != null) {
				return false;
			}
		} else if (!permissionName.equals(other.permissionName)) {
			return false;
		}
		return true;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	/**
	 * 
	 */
	Permission() {
		super();

	}

}
