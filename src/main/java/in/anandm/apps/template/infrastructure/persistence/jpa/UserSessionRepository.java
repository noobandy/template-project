package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.user.IUserSessionRepository;
import in.anandm.apps.template.domain.model.user.UserSession;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
@Repository
public class UserSessionRepository extends BaseRepository<UserSession, Long> implements IUserSessionRepository {

	@Override
	public void saveUserSession(UserSession userSession) {
		save(userSession);
	}

	@Override
	public List<UserSession> getUserSessionofUserWithId(String userId) {
		Search search = new Search(UserSession.class);
		search.addFilter(Filter.equal("user.userAccount.userId", userId));
		return search(search);
	}

	@Override
	public UserSession getUserSessionBySessionId(String sessionId) {

		Search search = new Search(UserSession.class);
		search.addFilter(Filter.equal("sessionId", sessionId));

		return searchUnique(search);
	}

}
