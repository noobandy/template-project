/**
 * 
 */
package in.anandm.apps.template.infrastructure.security.spring;

import in.anandm.apps.template.domain.service.SecurityContextHelper;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author anandm
 * 
 */
public class SecurityContextHelperImpl implements SecurityContextHelper {

	@Override
	public boolean isAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication()
				.isAuthenticated();

	}

	@Override
	public String[] getGrantedAuthorities() {
		Collection<? extends GrantedAuthority> grantedAuthorities = SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		String[] authorityNames = new String[grantedAuthorities.size()];

		int i = 0;
		for (GrantedAuthority grantedAuthority : grantedAuthorities) {
			authorityNames[i++] = grantedAuthority.getAuthority();
		}

		return authorityNames;
	}
}
