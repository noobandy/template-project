/**
 * 
 */
package in.anandm.apps.template.domain.model.menu;

import in.anandm.apps.template.domain.model.group.Group;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author anandm
 *
 */
@Entity
public class Menu {

	private String menuName;
	private String displayName;
	private String menuURL;
	private Boolean rootMenu;
	private Long activeFrom;
	private Long activeTo;


	@ManyToOne
	private Menu parentMenu;

	@OneToMany(mappedBy="parentMenu")
	private List<Menu> children = new ArrayList<Menu>();

	@ManyToMany(mappedBy="menus")
	private List<Group> groups = new ArrayList<Group>();

	public String getMenuName() {
		return menuName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getMenuURL() {
		return menuURL;
	}

	public Boolean getRootMenu() {
		return rootMenu;
	}

	public Long getActiveFrom() {
		return activeFrom;
	}

	public Long getActiveTo() {
		return activeTo;
	}

	public Menu getParentMenu() {
		return parentMenu;
	}

	public List<Menu> getChildren() {
		return children;
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
	Menu() {
		super();

	}
}
