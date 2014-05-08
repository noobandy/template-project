/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author noobandy
 *
 */
@Entity
public class User {

	@Embedded
	private UserAccount userAccount;
	@Embedded
	private UserProfile userProfile;
	
	@OneToMany(mappedBy="user")
	private List<FailedLoginAttempt> failedLoginAttempts = new ArrayList<FailedLoginAttempt>();
	@OneToMany(mappedBy="user")
	private List<SuccessfullLoginAttempt> successfullLoginAttempts = new ArrayList<SuccessfullLoginAttempt>();
	@OneToMany(mappedBy="user")
	private List<ActiveSession> activeSessions = new ArrayList<ActiveSession>();

	
	public User(UserAccount userAccount, UserProfile userProfile) {
		super();
		this.userAccount = userAccount;
		this.userProfile = userProfile;
	}

	/**
	 * @return the userAccount
	 */
	public UserAccount getUserAccount() {
		return userAccount;
	}

	/**
	 * @return the userProfile
	 */
	public UserProfile getUserProfile() {
		return userProfile;
	}

	/**
	 * @return the failedLoginAttempts
	 */
	public List<FailedLoginAttempt> getFailedLoginAttempts() {
		return failedLoginAttempts;
	}

	/**
	 * @return the successfullLoginAttempts
	 */
	public List<SuccessfullLoginAttempt> getSuccessfullLoginAttempts() {
		return successfullLoginAttempts;
	}

	/**
	 * @return the activeSessions
	 */
	public List<ActiveSession> getActiveSessions() {
		return activeSessions;
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

	User() {
		super();
	}


}
