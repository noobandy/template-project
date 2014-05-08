/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import java.io.Serializable;
import java.util.Date;

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
public class ActiveSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long startTime;
	
	@Embedded
	private HostAddress hostAddress;
	
	@ManyToOne
	private User user;

	public ActiveSession(Long startTime, HostAddress hostAddress,User user) {
		super();
		this.startTime = startTime;
		this.hostAddress = hostAddress;
		this.user = user;
	}

	public Long getStartTime() {
		return startTime;
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


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	ActiveSession() {
		// TODO Auto-generated constructor stub
	}

}
