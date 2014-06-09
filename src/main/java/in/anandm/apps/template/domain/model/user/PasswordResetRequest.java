/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import in.anandm.apps.template.domain.shared.entity.BaseEntity;
import in.anandm.apps.template.interfaces.web.helper.HashingUtility;

import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.Validate;

/**
 * @author anandm
 *
 */
@Entity
public class PasswordResetRequest extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resetKey;
	private Long initiatedOn;
	private Long expiredOn;

	@Embedded
	private HostAddress hostAddress;

	@ManyToOne
	private User user;


	/**
	 * @param resetKey
	 * @param initiatedOn
	 * @param hostAddress
	 * @param user
	 */
	public PasswordResetRequest(User user,HostAddress hostAddress) {
		super();
		this.hostAddress = hostAddress;
		this.user = user;
	}

	public String initiateRequest(){
		String newResetKey = UUID.randomUUID().toString();
		String hashedKey = HashingUtility.sha512Hash(newResetKey);

		resetKey = hashedKey;
		initiatedOn = System.currentTimeMillis();

		return newResetKey;

	}

	private boolean isExpired(){
		return (expiredOn != null && expiredOn < System.currentTimeMillis());
	}


	public void resetPassword(String resetKey,String newPassword){
		Validate.notEmpty(resetKey, "resetKey is empty");
		Validate.notEmpty(newPassword, "newPassword is empty");

		if(isExpired()){
			throw new IllegalStateException("Request is expired");
		}
		String hashedResetKey = HashingUtility.sha512Hash(resetKey);
		if(this.resetKey.equals(hashedResetKey)){
			user.changePassword(newPassword);
			expiredOn = System.currentTimeMillis();
		}else{
			throw new IllegalArgumentException("Invalid resetKey");
		}



	}


	public String getResetKey() {
		return resetKey;
	}
	public Long getInitiatedOn() {
		return initiatedOn;
	}
	public Long getExpiredOn() {
		return expiredOn;
	}
	public HostAddress getHostAddress() {
		return hostAddress;
	}
	public User getUser() {
		return user;
	}

	/**
	 * 
	 */
	PasswordResetRequest() {
		super();

	}


}
