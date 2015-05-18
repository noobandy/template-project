/**
 * 
 */
package in.anandm.apps.template.domain.model.menu;

import java.io.Serializable;
import java.util.Set;

/**
 * @author anandm
 * 
 */
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String parentMenuName;
	private int sequence;
	private String slug;
	private String title;
	private String desc;
	private String URL;
	private String icon;

	private Set<MenuLocale> menuLocales;

	/**
	 * @param name
	 * @param parentMenuName
	 * @param sequence
	 * @param title
	 * @param desc
	 * @param uRL
	 * @param icon
	 */
	public Menu(String name, String parentMenuName, int sequence, String title,
			String desc, String uRL, String icon) {
		super();
		this.name = name;
		this.parentMenuName = parentMenuName;
		this.sequence = sequence;
		this.title = title;
		this.desc = desc;
		URL = uRL;
		this.icon = icon;
	}

	public void addMenuLocale(MenuLocale menuLocale) {

	}

	public void removeMenuLocale(MenuLocale menuLocale) {

	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public String getParentMenuName() {
		return parentMenuName;
	}

	public String getSlug() {
		return slug;
	}

	public Set<MenuLocale> getMenuLocales() {
		return menuLocales;
	}

	public void setMenuLocales(Set<MenuLocale> menuLocales) {
		this.menuLocales = menuLocales;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Menu other = (Menu) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
