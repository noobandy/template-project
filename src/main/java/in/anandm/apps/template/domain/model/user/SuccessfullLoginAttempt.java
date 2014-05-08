/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import java.io.Serializable;

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
public class SuccessfullLoginAttempt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long succeededOn;
	@Embedded
	private HostAddress hostAddress;
	@ManyToOne
	private User user;
	
	
	
	public SuccessfullLoginAttempt(Long succeededOn, HostAddress hostAddress,User user) {
		super();
		this.succeededOn = succeededOn;
		this.hostAddress = hostAddress;
		this.user = user;
	}

	public Long getSucceededOn() {
		return succeededOn;
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
	
	SuccessfullLoginAttempt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
