/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import java.util.List;

/**
 * @author anandm
 *
 */
public interface IUserSessionRepository {

	void saveUserSession(UserSession userSession);

	List<UserSession> getUserSessionofUserWithId(String userId);

	UserSession getUserSessionBySessionId(String sessionId);
}
