/**
 * 
 */
package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.group.GroupUser;
import in.anandm.apps.template.domain.model.group.IGroupUserRepository;

import org.springframework.stereotype.Repository;

/**
 * @author anandm
 *
 */
@Repository
public class GroupUserRepository extends BaseRepository<GroupUser, Long> implements
IGroupUserRepository {

	@Override
	public void saveGroupUser(GroupUser groupUser) {
	}

	@Override
	public void deleteGroupUser(Long groupId, Long userId) {
		
	}

}
