/**
 * 
 */
package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.user.IUserRepository;
import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.interfaces.admin.web.DataTable;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

/**
 * @author anandm
 *
 */
@Repository
public class UserRepository implements IUserRepository{

	@Autowired
	private BaseRepository<User, Long> baseRepository;

	@Override
	public void save(User user) {
		baseRepository.save(user);
	}

	@Override
	public User getUserByUserId(String userId) {
		Search search = new Search(User.class);
		search.addFilter(Filter.equal("userId", userId));
		User foundUser = baseRepository.searchUnique(search);
		return foundUser;
	}

	@Override
	public DataTable<User> getDataTable(Map<String, String> params) {
		return baseRepository.getDataTable(User.class, params);
	}


}
