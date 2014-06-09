/**
 * 
 */
package in.anandm.apps.template.application.impl;

import in.anandm.apps.template.domain.model.user.HostAddress;
import in.anandm.apps.template.domain.model.user.ILoginAttemptRepository;
import in.anandm.apps.template.domain.model.user.IUserRepository;
import in.anandm.apps.template.domain.model.user.LoginAttempt;
import in.anandm.apps.template.domain.model.user.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author anandm
 *
 */
@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private ILoginAttemptRepository loginAttemptRepository;

	@Transactional
	@Override
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {

		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes())
				.getRequest(); 
		String ipAddress = request.getRemoteAddr();
		String userId = "";
		Object principal = event.getAuthentication().getPrincipal();
		if(principal instanceof String){
			userId = (String) principal;
		}else{
			UserDetails userDetails = (UserDetails) principal;
			userId = userDetails.getUsername();
		}

		User user = userRepository.getUserByUserId(userId);

		if(user != null){
			loginAttemptRepository.saveLoginAttempt(new LoginAttempt(user, new HostAddress(ipAddress), System.currentTimeMillis(), false));
		}

	}
}
