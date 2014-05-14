package in.anandm.apps.template.domain.model.user;

import javax.persistence.Embeddable;

@Embeddable
public class ProfilePicture {

	private String profilePicturePath;

	public String getProfilePicturePath() {
		return profilePicturePath;
	}


	ProfilePicture() {
		super();
		// TODO Auto-generated constructor stub
	}

}
