/**
 * 
 */
package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.domain.model.group.Group;
import in.anandm.apps.template.domain.model.user.User;

/**
 * @author anandm
 *
 */
public interface IGroupService {

	void addUserInGroup(Group group,User user);
	
	void removeUserFromGroup(Group group,User user);
	
}
