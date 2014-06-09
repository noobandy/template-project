/**
 * 
 */
package in.anandm.apps.template.application.impl;

import in.anandm.apps.template.domain.model.group.Group;
import in.anandm.apps.template.domain.model.group.GroupUser;
import in.anandm.apps.template.domain.model.group.IGroupUserRepository;
import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.domain.service.IGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author anandm
 *
 */
@Service
public class GroupService implements IGroupService {

	private IGroupUserRepository groupUserRepository;


	/**
	 * @param groupUserRepository
	 */
	@Autowired
	public GroupService(IGroupUserRepository groupUserRepository) {
		super();
		this.groupUserRepository = groupUserRepository;
	}

	@Override
	public void addUserInGroup(Group group, User user) {
		GroupUser groupUser = new GroupUser(group.getId(), user.getId());
		groupUserRepository.saveGroupUser(groupUser);
	}

	@Override
	public void removeUserFromGroup(Group group, User user) {
		groupUserRepository.deleteGroupUser(group.getId(), user.getId());
	}

}
