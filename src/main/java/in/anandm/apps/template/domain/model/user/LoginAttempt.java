/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import in.anandm.apps.template.domain.shared.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author anandm
 *
 */
@Entity
public class LoginAttempt extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private User user;

	private HostAddress hostAddress;
	private Long attemptedOn;
	private boolean success;

	/**
	 * @param user
	 * @param hostAddress
	 * @param attemptedOn
	 * @param success
	 */
	public LoginAttempt(User user, HostAddress hostAddress, Long attemptedOn,
			boolean success) {
		super();
		this.user = user;
		this.hostAddress = hostAddress;
		this.attemptedOn = attemptedOn;
		this.success = success;
	}

	public HostAddress getHostAddress() {
		return hostAddress;
	}

	public Long getAttemptedOn() {
		return attemptedOn;
	}

	public boolean isSuccess() {
		return success;
	}

	public User getUser() {
		return user;
	}

	/**
	 * 
	 */
	LoginAttempt() {
		super();
		
	}

}
