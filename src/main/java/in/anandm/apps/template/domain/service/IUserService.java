package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.application.dto.DataTable;
import in.anandm.apps.template.application.dto.UserDTO;
import in.anandm.apps.template.domain.model.user.User;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface IUserService {

	@Transactional
	void addUser(User user);
	
	DataTable<UserDTO> getDataTable(Map<String, String> params);
}