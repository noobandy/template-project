/**
 * 
 */
package in.anandm.apps.template.domain.model.group;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author anandm
 *
 */
public interface IGroupUserRepository {

	@Transactional
	void saveGroupUser(GroupUser groupUser);

	void deleteGroupUser(Long groupId,Long userId);
}
