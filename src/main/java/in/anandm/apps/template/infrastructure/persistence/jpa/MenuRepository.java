/**
 * 
 */
package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.menu.IMenuRepository;
import in.anandm.apps.template.domain.model.menu.Menu;
import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

/**
 * @author anandm
 * 
 */
public class MenuRepository extends BaseRepository<Menu, String> implements
		IMenuRepository {

	@Override
	public Menu saveMenu(Menu menu) {

		return save(menu);
	}

	@Override
	public List<Menu> getAllMenu() {

		return findAll();
	}

	@Override
	public Menu getMenuByName(String menuName) {

		return find(menuName);
	}

	@Override
	public void deleteMenuByName(String menuName) {
		removeById(menuName);
	}

	@Override
	public DataTable<Menu> getDataTable(Map<String, String> params) {

		return getDataTable(Menu.class, params);
	}

	@Override
	@Transactional
	public Menu findMenuByURL(String prefix) {
		Search search = new Search(Menu.class);
		search.addFilter(Filter.equal("URL", prefix));
		return searchUnique(search);
	}

}
