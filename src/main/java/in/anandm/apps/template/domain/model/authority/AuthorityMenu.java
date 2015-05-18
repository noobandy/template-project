/**
 * 
 */
package in.anandm.apps.template.domain.model.authority;

import in.anandm.apps.template.domain.model.menu.Menu;

import java.io.Serializable;
import java.util.Date;

/**
 * @author anandm
 * 
 */
public class AuthorityMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Menu menu;
	private Date validFrom;
	private Date validTill;

	/**
	 * @param menu
	 * @param validFrom
	 * @param validTill
	 */
	public AuthorityMenu(Menu menu, Date validFrom, Date validTill) {
		super();
		this.menu = menu;
		this.validFrom = validFrom;
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

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public Menu getMenu() {
		return menu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
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
		AuthorityMenu other = (AuthorityMenu) obj;
		if (menu == null) {
			if (other.menu != null) {
				return false;
			}
		} else if (!menu.equals(other.menu)) {
			return false;
		}
		return true;
	}

}
