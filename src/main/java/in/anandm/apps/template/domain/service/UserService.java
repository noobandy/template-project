/**
 * 
 */
package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.application.dto.DataTable;
import in.anandm.apps.template.application.dto.UserDTO;
import in.anandm.apps.template.application.impl.UserRepository;
import in.anandm.apps.template.domain.model.user.User;

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
	private UserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public DataTable<UserDTO> getDataTable(Map<String, String> params) {
		DataTable<User> userDataTable = userRepository.getDataTable(User.class,params);
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

}
