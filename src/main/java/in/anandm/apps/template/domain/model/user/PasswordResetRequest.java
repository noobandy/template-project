/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author anandm
 *
 */
@Entity
public class PasswordResetRequest {

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
	public PasswordResetRequest(String resetKey, Long initiatedOn,
			HostAddress hostAddress, User user) {
		super();
		this.resetKey = resetKey;
		this.initiatedOn = initiatedOn;
		this.hostAddress = hostAddress;
		this.user = user;
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


	public boolean isExpired(){
		return (expiredOn != null && expiredOn < System.currentTimeMillis());
	}

	public void expire(){
		this.expiredOn = System.currentTimeMillis();
	}
	public boolean verify(String resetKey){
		return this.resetKey.equals(resetKey);
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}
	/**
	 * 
	 */
	PasswordResetRequest() {
		super();

	}

}
