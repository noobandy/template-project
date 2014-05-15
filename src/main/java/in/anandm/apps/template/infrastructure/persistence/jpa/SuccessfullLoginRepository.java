package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.user.ISuccessfullLoginRepository;
import in.anandm.apps.template.domain.model.user.SuccessfullLogin;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
@Repository
public class SuccessfullLoginRepository extends BaseRepository<SuccessfullLogin, Long> implements ISuccessfullLoginRepository {

	@Override
	public void saveSuccessfullLogin(SuccessfullLogin successfullLogin) {
		save(successfullLogin);
	}

	@Override
	public List<SuccessfullLogin> getSuccessfullLoginofUserWithId(String userId) {
		Search search = new Search(SuccessfullLogin.class);
		search.addFilter(Filter.equal("user.userAccount.userId", userId));
		return search(search);
	}

}
