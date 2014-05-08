/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

/**
 * @author noobandy
 *
 */
@Embeddable
public class UserAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String userId;
	private String password;
	private Boolean admin;
	private Boolean enabled;
	private Long expireOn;

	public UserAccount(String userId, String password, Boolean admin,
			Boolean enabled, Long expireOn) {
		super();
		this.userId = userId;
		this.password = password;
		this.admin = admin;
		this.enabled = enabled;
		this.expireOn = expireOn;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the admin
	 */
	public Boolean getAdmin() {
		return admin;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}


	/**
	 * @return the expireOn
	 */
	public Long getExpireOn() {
		return expireOn;
	}

	UserAccount() {
		super();
	}

	


}
