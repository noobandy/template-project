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
	private List<FailedLogin> failedLogins = new ArrayList<FailedLogin>();
	@OneToMany(mappedBy="user")
	private List<SuccessfullLogin> successfullLogins = new ArrayList<SuccessfullLogin>();
	@OneToMany(mappedBy="user")
	private List<UserSession> userSessions = new ArrayList<UserSession>();

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
	public List<FailedLogin> getFailedLogins() {
		return failedLogins;
	}

	/**
	 * @return the successfullLoginAttempts
	 */
	public List<SuccessfullLogin> getSuccessfullLogins() {
		return successfullLogins;
	}

	/**
	 * @return the activeSessions
	 */
	public List<UserSession> getActiveSessions() {
		return userSessions;
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
