package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.interfaces.web.DataTable;
import in.anandm.apps.template.interfaces.web.UserDTO;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface IUserService {

	@Transactional
	void addUser(User user);
	
	DataTable<UserDTO> getDataTable(Map<String, String> params);
}