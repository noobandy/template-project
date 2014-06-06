/**
 * 
 */
package in.anandm.apps.template.domain.model.authority;

import in.anandm.apps.template.domain.model.permission.Permission;

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
public class Authority {


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

	public boolean hasPermission(Permission permission){
		return permissions.contains(permission);
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
	Authority() {
		super();

	}

}
