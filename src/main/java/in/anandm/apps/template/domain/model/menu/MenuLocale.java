/**
 * 
 */
package in.anandm.apps.template.domain.model.menu;

/**
 * @author anandm
 * 
 */
public class MenuLocale {

	private String locale;
	private String title;
	private String desc;

	/**
	 * @param locale
	 * @param title
	 * @param desc
	 */
	public MenuLocale(String locale, String title, String desc) {
		super();
		this.locale = locale;
		this.title = title;
		this.desc = desc;
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

	public String getLocale() {
		return locale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
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
		MenuLocale other = (MenuLocale) obj;
		if (locale == null) {
			if (other.locale != null) {
				return false;
			}
		} else if (!locale.equals(other.locale)) {
			return false;
		}
		return true;
	}
}
