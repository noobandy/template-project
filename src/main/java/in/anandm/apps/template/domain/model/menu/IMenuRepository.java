/**
 * 
 */
package in.anandm.apps.template.domain.model.menu;

import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.List;
import java.util.Map;

/**
 * @author anandm
 * 
 */
public interface IMenuRepository {

	Menu saveMenu(Menu menu);

	List<Menu> getAllMenu();

	Menu getMenuByName(String menuName);

	Menu findMenuByURL(String URL);

	void deleteMenuByName(String menuName);

	DataTable<Menu> getDataTable(Map<String, String> params);

}
