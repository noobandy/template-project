/**
 * 
 */
package in.anandm.apps.template.application.impl;

import in.anandm.apps.template.application.vo.CustomUserDetails;
import in.anandm.apps.template.domain.model.user.HostAddress;
import in.anandm.apps.template.domain.model.user.ILoginAttemptRepository;
import in.anandm.apps.template.domain.model.user.IUserRepository;
import in.anandm.apps.template.domain.model.user.IUserSessionRepository;
import in.anandm.apps.template.domain.model.user.LoginAttempt;
import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.domain.model.user.UserSession;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author anandm
 *
 */
@Component
public class AutheticationSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private ILoginAttemptRepository loginAttemptRepository;
	@Autowired
	private IUserSessionRepository userSessionRepository;

	@Transactional
	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes())
				.getRequest(); 
		String ipAddress = request.getRemoteAddr();
		String userId = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if(principal instanceof String) {
			userId = (String) principal;
		}else{
			CustomUserDetails userDetails = (CustomUserDetails) principal;
			userId = userDetails.getUsername();
		}

		User user = userRepository.getUserByUserId(userId);

		loginAttemptRepository.saveLoginAttempt(new LoginAttempt(user, new HostAddress(ipAddress), System.currentTimeMillis(), true));

		userSessionRepository.saveUserSession(new UserSession(RequestContextHolder.currentRequestAttributes().getSessionId(),event.getTimestamp(), new HostAddress(ipAddress), user));
	}

}
