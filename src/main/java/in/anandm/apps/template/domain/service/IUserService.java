package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;
import in.anandm.apps.template.interfaces.web.facade.dto.RegistrationFormDTO;
import in.anandm.apps.template.interfaces.web.facade.dto.UserDTO;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface IUserService {


	@Transactional
	void registerUser(RegistrationFormDTO registrationFormDTO);

	@Transactional
	void initiatePasswordResetRequest(User user,String hostAddress) throws NoSuchAlgorithmException;

	DataTable<UserDTO> getDataTable(Map<String, String> params);
}