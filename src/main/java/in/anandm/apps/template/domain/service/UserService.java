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
import in.anandm.apps.template.domain.shared.exception.PasswordResetRequestExpired;
import in.anandm.apps.template.domain.shared.exception.PasswordResetRequestNotFound;
import in.anandm.apps.template.interfaces.web.dto.DataTable;
import in.anandm.apps.template.interfaces.web.dto.RegistrationFormDTO;
import in.anandm.apps.template.interfaces.web.dto.UserDTO;
import in.anandm.apps.template.interfaces.web.helper.HashingUtility;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
	public void addUser(User user) {
		userRepository.saveUser(user);
	}

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
		char[] password = HashingUtility.hashedPassword(registrationFormDTO.getPassword(), registrationFormDTO.getUserId());
		String verificationKey = UUID.randomUUID().toString();

		UserAccount userAccount = new UserAccount(userId, password, false, null, HashingUtility.hexEncodedHash(verificationKey.getBytes(), "SHA-512"));

		String firstName = registrationFormDTO.getFirstName();
		String lastName = registrationFormDTO.getLastName();
		Gender gender = registrationFormDTO.getGender();
		long dob = registrationFormDTO.getDob().getTime();
		String emailId = registrationFormDTO.getEmailId();

		UserProfile userProfile = new UserProfile(firstName, lastName, gender, dob, emailId, null, null);

		User user = new User(userAccount, userProfile);
		userRepository.saveUser(user);

		emailService.sendAccountVerificationEmail(emailId, verificationKey);




	}

	@Override
	public void initiatePasswordResetRequest(User user,String hostAddress) throws NoSuchAlgorithmException {
		String resetKey = UUID.randomUUID().toString();

		PasswordResetRequest passwordResetRequest = new PasswordResetRequest(HashingUtility.hexEncodedHash(resetKey.getBytes(), "SHA-512"), System.currentTimeMillis(), new HostAddress(hostAddress), user);
		passwordResetRequestRepository.savePasswordResetRequest(passwordResetRequest);
		emailService.sendPasswordResetEmail(user.getUserProfile().getEmailId(), resetKey);
	}

	@Override
	public void resetPassword(String resetKey, String newPassword) {
		PasswordResetRequest passwordResetRequest = passwordResetRequestRepository.getPasswordResetRequestByKey(resetKey);

		if(passwordResetRequest == null){
			throw new PasswordResetRequestNotFound();
		}

		if(passwordResetRequest.verify(resetKey)){
			User user = passwordResetRequest.getUser();
			user.getUserAccount().changePassword(newPassword);
			userRepository.saveUser(user);
			passwordResetRequest.expire();
			passwordResetRequestRepository.savePasswordResetRequest(passwordResetRequest);
		}else{
			throw new PasswordResetRequestExpired();
		}
	}

}
