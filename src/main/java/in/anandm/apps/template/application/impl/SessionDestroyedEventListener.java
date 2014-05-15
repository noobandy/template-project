/**
 * 
 */
package in.anandm.apps.template.application.impl;

import in.anandm.apps.template.domain.model.user.IUserSessionRepository;
import in.anandm.apps.template.domain.model.user.UserSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author anandm
 *
 */
@Component
public class SessionDestroyedEventListener implements ApplicationListener<SessionDestroyedEvent> {

	@Autowired
	private IUserSessionRepository userSessionRepository;

	@Transactional
	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		UserSession userSession = userSessionRepository.getUserSessionBySessionId(event.getId());
		if(userSession != null){
			userSession.endSession();
			userSessionRepository.saveUserSession(userSession);
		}		
	}

}
