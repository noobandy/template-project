/**
 * 
 */
package in.anandm.apps.template.interfaces.web;

import in.anandm.apps.template.domain.model.user.Gender;
import in.anandm.apps.template.domain.model.user.User;

import java.io.Serializable;

/**
 * @author anandm
 *
 */
public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String userId;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Long dob;
	private String emailId;
	private String contactNumber;
	private Long expireOn;
	private Boolean admin;
	private Boolean enabled;

	/**
	 * 
	 */
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.userId = user.getUserAccount().getUserId();
		this.firstName = user.getUserProfile().getFirstName();
		this.lastName = user.getUserProfile().getLastName();
		this.gender = user.getUserProfile().getGender();
		this.dob = user.getUserProfile().getDob();
		this.emailId = user.getUserProfile().getEmailId();
		this.contactNumber = user.getUserProfile().getContactNumber();
		this.expireOn = user.getUserAccount().getExpireOn();
		this.admin = user.getUserAccount().getAdmin();
		this.enabled = user.getUserAccount().getEnabled();
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public Long getDob() {
		return dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public Long getExpireOn() {
		return expireOn;
	}
	public Boolean getEnabled() {
		return enabled;
	}
}
