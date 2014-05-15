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
 * @author noobandy
 *
 */
@Entity
public class FailedLogin {

	private Long failedOn;
	
	@Embedded
	private HostAddress hostAddress;
	@ManyToOne
	private User user;
	


	public FailedLogin(Long failedOn, HostAddress hostAddress,User
			 user) {
		super();
		this.failedOn = failedOn;
		this.hostAddress = hostAddress;
		this.user = user;
	}


	public Long getFailedOn() {
		return failedOn;
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


	public Long getId() {
		return id;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;


	FailedLogin() {
		super();
		// TODO Auto-generated constructor stub
	}


}
