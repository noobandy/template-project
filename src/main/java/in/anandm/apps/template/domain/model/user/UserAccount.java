/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import in.anandm.apps.template.interfaces.web.helper.HashingUtility;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Embeddable;

import org.apache.commons.lang.Validate;

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
	private String verificationKey;
	private Long verifiedOn;

	public UserAccount(String userId,String password) {
		super();
		Validate.notEmpty(userId, "userId is empty");

		Validate.notEmpty(password, "password is empty");


		this.userId = userId;

		Validate.notEmpty(password, "password is empty");
		String saltedPassword = password + "{" + userId + "}";
		String hashedPassword = HashingUtility.sha512Hash(saltedPassword);
		this.password = hashedPassword;

		this.admin = false;
		this.expireOn = null;
		this.enabled = false;
	}


	void makeAdmin(){
		admin = true;
	}

	void makeNonAdmin(){
		admin = false;
	}
	void enable(){
		enabled = true;
	}

	void disable(){
		enabled = false;
	}

	void changePassword(String newPassword){
		Validate.notEmpty(newPassword, "password is empty");
		String saltedPassword = newPassword + "{" + userId + "}";
		String hashedPassword = HashingUtility.sha512Hash(saltedPassword);
		password = hashedPassword;
	}

	String requestVerification(){
		if(isVerified()){
			throw new IllegalStateException("User Account is already verified");
		}
		String newVerificationKey = UUID.randomUUID().toString();
		String hashedKey = HashingUtility.sha512Hash(newVerificationKey);
		this.verificationKey = hashedKey;
		return newVerificationKey;
	}

	boolean isVerified(){
		return verifiedOn != null;
	}

	void verify(String verificationKey){
		Validate.notEmpty(verificationKey, "verificationKey is empty");

		if(isVerified()){
			throw new IllegalStateException("User Account is already verified");
		}

		String hashedVerificationKey = HashingUtility.sha512Hash(verificationKey);

		if(this.verificationKey.equals(hashedVerificationKey)){
			enabled = true;
			verifiedOn = System.currentTimeMillis();
		}
	}

	boolean isExpired(){
		return (expireOn != null && expireOn < System.currentTimeMillis());
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public Long getExpireOn() {
		return expireOn;
	}

	public String getVerificationKey() {
		return verificationKey;
	}

	public Long getVerifiedOn() {
		return verifiedOn;
	}

	UserAccount() {
		super();
	}
}
