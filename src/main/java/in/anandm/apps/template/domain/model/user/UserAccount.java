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
	private String password;
	private Boolean admin;
	private Boolean enabled;
	private Long expireOn;
	private String verificationKey;
	private Long verifiedOn;

	public UserAccount(String userId,String password, Boolean admin,
			Long expireOn,String verificationKey) {
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

	public void changePassword(String newPassword){
		this.password = newPassword;
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
