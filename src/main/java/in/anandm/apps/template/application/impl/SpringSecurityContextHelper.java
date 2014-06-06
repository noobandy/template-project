/**
 * 
 */
package in.anandm.apps.template.application.impl;

import in.anandm.apps.template.application.vo.CustomUserDetails;
import in.anandm.apps.template.domain.helper.ISecurityContextHelper;
import in.anandm.apps.template.domain.model.authority.Authority;
import in.anandm.apps.template.domain.model.user.IUserRepository;
import in.anandm.apps.template.domain.model.user.User;

import java.util.Collection;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author anandm
 *
 */
public class SpringSecurityContextHelper implements ISecurityContextHelper {

	private IUserRepository userRepository;

	@Override
	public User authenticatedUser() {

		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return userRepository.getUserByUserId(userDetails.getUserId());
	}

	@Override
	public Collection<Authority> getAuthorities() {

		return null;
	}

}
