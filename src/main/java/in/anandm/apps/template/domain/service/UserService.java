/**
 * 
 */
package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.application.impl.UserRepository;
import in.anandm.apps.template.domain.model.user.User;

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
	public void addUser(User user){
		userRepository.save(user);
	}
}
