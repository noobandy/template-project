/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import in.anandm.apps.template.domain.shared.entity.BaseEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author noobandy
 *
 */
@Entity
public class UserSession extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long startTime;
	private Long endTime;
	private String sessionId;

	@Embedded
	private HostAddress hostAddress;

	@ManyToOne
	private User user;

	public UserSession(String sessionId,Long startTime, HostAddress hostAddress,User user) {
		super();
		this.sessionId = sessionId;
		this.startTime = startTime;
		this.hostAddress = hostAddress;
		this.user = user;
	}

	public String getSessionId() {
		return sessionId;
	}

	public Long getStartTime() {
		return startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public HostAddress getHostAddress() {
		return hostAddress;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	public void endSession(){
		this.endTime = System.currentTimeMillis();
	}

	/**
	 * 
	 */
	UserSession() {
		super();
		
	}

	
}
