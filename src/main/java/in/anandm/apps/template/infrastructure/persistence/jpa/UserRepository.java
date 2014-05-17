/**
 * 
 */
package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.user.IUserRepository;
import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.interfaces.web.dto.DataTable;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

/**
 * @author anandm
 *
 */
@Repository
public class UserRepository extends BaseRepository<User, Long> implements IUserRepository{

	@Override
	public void saveUser(User user) {
		save(user);
	}

	@Override
	public User getUserByUserId(String userId) {
		Search search = new Search(User.class);
		search.addFilter(Filter.equal("userAccount.userId", userId));
		User foundUser = searchUnique(search);
		return foundUser;
	}

	@Override
	public DataTable<User> getDataTable(Map<String, String> params) {
		return getDataTable(User.class, params);
	}

	@Override
	public User getUserByVerificationKey(String verificationKey) {

		Search search = new Search(User.class);
		search.addFilter(Filter.equal("userAccount.verificationKey", verificationKey));
		User foundUser = searchUnique(search);
		return foundUser;
	}
}
