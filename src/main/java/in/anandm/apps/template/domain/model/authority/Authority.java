/**
 * 
 */
package in.anandm.apps.template.domain.model.authority;

import in.anandm.apps.template.domain.model.permission.Permission;
import in.anandm.apps.template.domain.shared.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * @author anandm
 *
 */
@Entity
public class Authority extends BaseEntity{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String authority;

	@ManyToMany
	private List<Permission> permissions = new ArrayList<Permission>();



	/**
	 * @param authority
	 */
	public Authority(String authority) {
		super();
		this.authority = authority;
	}

	public String getAuthority() {
		return authority;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void addPermission(Permission permission){
		permissions.add(permission);
	}

	public void removePermission(Permission permission){
		permissions.remove(permission);
	}

	public boolean allowed(Permission permission){
		for (Permission p : permissions) {
			if(p.equals(permission) && !p.isExpired()){
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 */
	Authority() {
		super();

	}


}
