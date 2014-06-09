/**
 * 
 */
package in.anandm.apps.template.domain.model.group;

import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author anandm
 *
 */
public interface IGroupRepository {

	@Transactional
	void saveGroup(Group group);

	@Transactional(readOnly=true)
	Group getGroupById(Long id);

	@Transactional(readOnly=true)
	Group getGroupByGroupName(String groupName);

	@Transactional(readOnly=true)
	DataTable<Group> getDataTable(Map<String, String> params);
}
