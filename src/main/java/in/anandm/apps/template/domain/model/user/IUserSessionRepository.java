/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author anandm
 *
 */
public interface IUserSessionRepository {

	@Transactional
	void saveUserSession(UserSession userSession);

	List<UserSession> getUserSessionofUserWithId(String userId);

	UserSession getUserSessionBySessionId(String sessionId);
}
