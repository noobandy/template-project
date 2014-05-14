/**
 * 
 */
package in.anandm.apps.template.domain.model.permission;

import in.anandm.apps.template.domain.model.role.Role;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author anandm
 *
 */
@Entity
public class Permission {

	private String permissionName;
	private String moduleName;

	@ManyToMany(mappedBy="permissions")
	private List<Role> roles = new ArrayList<Role>();

	public String getPermissionName() {
		return permissionName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public List<Role> getRoles() {
		return roles;
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
