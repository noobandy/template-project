/**
 * 
 */
package in.anandm.apps.template.domain.model.role;

import in.anandm.apps.template.domain.model.group.Group;
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
public class Role {


	private String roleName;

	@ManyToMany
	private List<Permission> permissions = new ArrayList<Permission>();

	@ManyToMany(mappedBy="roles")
	private List<Group> groups = new ArrayList<Group>();

	public String getRoleName() {
		return roleName;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}


	public List<Group> getGroups() {
		return groups;
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
	Role() {
		super();

	}

}
