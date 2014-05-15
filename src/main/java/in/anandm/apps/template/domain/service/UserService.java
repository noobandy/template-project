/**
 * 
 */
package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.domain.model.user.IUserRepository;
import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.interfaces.web.DataTable;
import in.anandm.apps.template.interfaces.web.UserDTO;

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

}
