/**
 * 
 */
package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.group.Group;
import in.anandm.apps.template.domain.model.group.IGroupRepository;
import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * @author anandm
 *
 */
@Repository
public class GroupRepository extends BaseRepository<Group, Long> implements IGroupRepository {

	@Override
	public void saveGroup(Group group) {
		save(group);
	}

	@Override
	public Group getGroupById(Long id) {

		return find(id);
	}

	@Override
	public Group getGroupByGroupName(String groupName) {

		return null;
	}

	@Override
	public DataTable<Group> getDataTable(Map<String, String> params) {

		return getDataTable(Group.class, params);
	}

}
