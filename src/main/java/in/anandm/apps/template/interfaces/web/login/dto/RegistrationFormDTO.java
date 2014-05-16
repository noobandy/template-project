/**
 * 
 */
package in.anandm.apps.template.interfaces.web.login.dto;

import in.anandm.apps.template.domain.model.user.Gender;
import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.domain.model.user.UserAccount;
import in.anandm.apps.template.domain.model.user.UserProfile;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.apache.commons.codec.binary.Hex;

/**
 * @author anandm
 *
 */
public class RegistrationFormDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private Gender gender;
	private Date dob;
	private String emailId;
	private String userId;
	private String password;
	private String repeatPassword;

	/**
	 * 
	 */
	public RegistrationFormDTO() {
		super();

	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public User asUser() throws NoSuchAlgorithmException{
		MessageDigest digest = MessageDigest.getInstance("SHA-512");
		String saltAndPass = password+"{"+userId+"}";
		digest.update(saltAndPass.getBytes());
		
		UserAccount userAccount = new UserAccount(userId,Hex.encodeHexString(digest.digest()), false, true, null);
		UserProfile userProfile = new UserProfile(firstName, lastName, gender, dob.getTime(), emailId, null, null);
		return  new User(userAccount, userProfile);
	}


}
