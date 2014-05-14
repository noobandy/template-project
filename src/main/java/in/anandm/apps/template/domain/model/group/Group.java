/**
 * 
 */
package in.anandm.apps.template.domain.model.group;

import in.anandm.apps.template.domain.model.menu.Menu;
import in.anandm.apps.template.domain.model.role.Role;
import in.anandm.apps.template.domain.model.user.User;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author anandm
 *
 */
@Entity
@Table(name="_group")
public class Group {

	private String groupName;
	private Boolean denyGroup;
	private Boolean enabled;

	@ManyToMany
	private List<User> users = new ArrayList<User>();
	
	@ManyToMany
	private List<Menu> menus = new ArrayList<Menu>();
	
	@ManyToMany
	private List<Role> roles = new ArrayList<Role>();

	public String getGroupName() {
		return groupName;
	}
	public Boolean getDenyGroup() {
		return denyGroup;
	}
	public Boolean getEnabled() {
		return enabled;
	}

	public List<User> getUsers() {
		return users;
	}
	public List<Menu> getMenus() {
		return menus;
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
	Group() {
		super();

	}
}
