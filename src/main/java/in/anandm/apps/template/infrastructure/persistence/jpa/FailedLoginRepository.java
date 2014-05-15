package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.user.FailedLogin;
import in.anandm.apps.template.domain.model.user.IFailedLoginRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
@Repository
public class FailedLoginRepository extends BaseRepository<FailedLogin, Long> implements IFailedLoginRepository {

	@Override
	public void saveFailedLogin(FailedLogin failedLogin) {
		save(failedLogin);
	}

	@Override
	public List<FailedLogin> getFailedLoginofUserWithId(String userId) {
		Search search = new Search(FailedLogin.class);
		search.addFilter(Filter.equal("user.userAccount.userId", userId));
		return search(search);
	}

}
