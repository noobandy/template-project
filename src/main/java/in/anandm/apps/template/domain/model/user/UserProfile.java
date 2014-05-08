/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author noobandy
 *
 */
@Embeddable
public class UserProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private Gender gender;
	private Long dob;
	private String emailId;
	private String contactNumber;
	@Embedded
	private ProfilePicture profilePicture;

	public UserProfile(String firstName, String lastName, Gender gender,
			Long dob, String emailId, String contactNumber,
			ProfilePicture profilePicture) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.profilePicture = profilePicture;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @return the dob
	 */
	public Long getDob() {
		return dob;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @return the profilePicture
	 */
	public ProfilePicture getProfilePicture() {
		return profilePicture;
	}


	UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}



}
