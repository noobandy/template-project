/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import in.anandm.apps.template.domain.model.group.Group;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author noobandy
 *
 */
@Entity
//@JsonIgnoreProperties({"failedLoginAttempts","successfullLoginAttempts","activeSessions"})
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

	@ManyToMany(mappedBy="users")
	private List<Group> groups = new ArrayList<Group>();

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

	public List<Group> getGroups() {
		return groups;
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
