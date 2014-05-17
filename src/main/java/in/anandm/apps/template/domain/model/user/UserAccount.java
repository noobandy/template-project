/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import java.io.Serializable;

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
	private char[] password;
	private Boolean admin;
	private Boolean enabled;
	private Long expireOn;
	private char[] verificationKey;
	private Long verifiedOn;

	public UserAccount(String userId, char[] password, Boolean admin,
			Long expireOn,char[] verificationKey) {
		super();
		this.userId = userId;
		this.password = password;
		this.admin = admin;
		this.expireOn = expireOn;
		this.verificationKey = verificationKey;
		this.enabled = false;
	}

	public String getUserId() {
		return userId;
	}

	public char[] getPassword() {
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

	public char[] getVerificationKey() {
		return verificationKey;
	}

	public Long getVerifiedOn() {
		return verifiedOn;
	}

	public void changePassword(String newPassword){
		this.password = newPassword.toCharArray();
	}
	
	public boolean isExpired(){
		return (expireOn != null && expireOn < System.currentTimeMillis());
	}

	public void verify(String verificationKey){
		if(String.valueOf(this.verificationKey).equals(verificationKey)){
			this.verifiedOn = System.currentTimeMillis();
			this.enabled = Boolean.valueOf(true);
		}
	}

	public boolean isVerified(){
		return (verifiedOn != null);
	}

	UserAccount() {
		super();
	}
}
