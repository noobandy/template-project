/**
 * 
 */
package in.anandm.apps.template.domain.model.group;

import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.Map;

/**
 * @author anandm
 *
 */
public interface IGroupRepository {

	void save(Group group);
	Group getGroupById(Long id);
	Group getGroupByGroupName(String groupName);
	DataTable<Group> getDataTable(Map<String, String> params);
}
