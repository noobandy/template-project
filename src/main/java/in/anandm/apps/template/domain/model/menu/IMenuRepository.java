/**
 * 
 */
package in.anandm.apps.template.domain.model.menu;

import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.Map;


/**
 * @author anandm
 *
 */
public interface IMenuRepository {

	void save(Menu menu);
	Menu getMenuByMenuName(String menuName);
	Menu getMenuByMenuURL(String menuURL);
	DataTable<Menu> getDataTable(Map<String, String> params);
}
