/**
 * 
 */
package in.anandm.apps.template.interfaces.web.facade.internal.assembler;

import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.interfaces.web.facade.dto.UserDTO;

/**
 * @author anandm
 *
 */
public class UserDTOAssembler {

	public UserDTO toUserDTO(User user){
		return new UserDTO(user);
	}
	
	public User fromUserDTO(UserDTO userDTO){
		
	}
}
