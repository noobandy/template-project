/**
 * 
 */
package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.domain.model.user.Gender;
import in.anandm.apps.template.domain.model.user.HostAddress;
import in.anandm.apps.template.domain.model.user.IPasswordResetRequestRepository;
import in.anandm.apps.template.domain.model.user.IUserRepository;
import in.anandm.apps.template.domain.model.user.PasswordResetRequest;
import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.domain.model.user.UserAccount;
import in.anandm.apps.template.domain.model.user.UserProfile;
import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;
import in.anandm.apps.template.interfaces.web.facade.dto.RegistrationFormDTO;
import in.anandm.apps.template.interfaces.web.facade.dto.UserDTO;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author anandm
 * 
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IPasswordResetRequestRepository passwordResetRequestRepository;
	@Autowired
	private IEmailService emailService;

	
	@Override
	public DataTable<UserDTO> getDataTable(Map<String, String> params) {
		DataTable<User> userDataTable = userRepository.getDataTable(params);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		List<User> users = userDataTable.getAaData();
		for (User user : users) {
			userDTOs.add(new UserDTO(user));
		}
		DataTable<UserDTO> userDTODataTable = new DataTable<UserDTO>(
				userDataTable.getsEcho(), userDataTable.getiTotalRecords(),
				userDataTable.getiTotalDisplayRecords(), userDTOs);
		return userDTODataTable;
	}

	@Override
	public void registerUser(RegistrationFormDTO registrationFormDTO) {

		String userId = registrationFormDTO.getUserId();
		String password = registrationFormDTO.getPassword();

		UserAccount userAccount = new UserAccount(userId, password);

		String firstName = registrationFormDTO.getFirstName();
		String lastName = registrationFormDTO.getLastName();
		Gender gender = registrationFormDTO.getGender();
		long dob = registrationFormDTO.getDob().getTime();
		String emailId = registrationFormDTO.getEmailId();

		UserProfile userProfile = new UserProfile(firstName, lastName, gender, dob, emailId, null, null);

		User user = new User(userAccount, userProfile);

		String verificationKey = user.requestVerification();

		userRepository.saveUser(user);

		emailService.sendAccountVerificationEmail(userId,emailId, verificationKey);
	}



	@Override
	public void initiatePasswordResetRequest(User user,String hostAddress) throws NoSuchAlgorithmException {


		PasswordResetRequest passwordResetRequest = new PasswordResetRequest(user,new HostAddress(hostAddress));

		String resetKey = passwordResetRequest.initiateRequest();

		passwordResetRequestRepository.savePasswordResetRequest(passwordResetRequest);

		emailService.sendPasswordResetEmail(passwordResetRequest.getId(),user.getUserProfile().getEmailId(), resetKey);
	}



}
