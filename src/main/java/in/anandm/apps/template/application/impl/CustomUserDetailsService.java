/**
 * 
 */
package in.anandm.apps.template.application.impl;

import in.anandm.apps.template.application.vo.CustomUserDetails;
import in.anandm.apps.template.domain.model.user.IUserRepository;
import in.anandm.apps.template.domain.model.user.User;
import in.anandm.apps.template.domain.model.user.UserAccount;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author anandm
 *
 */
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.getUserByUserId(username);
		if(user == null){
			throw new UsernameNotFoundException("user name not found exception");
		}else{
			UserAccount account = user.getUserAccount();

			boolean accountNonExpired = true;
			if(account.getExpireOn() != null ){
				accountNonExpired = account.getExpireOn() > System.currentTimeMillis();
			}
			List<GrantedAuthority> authorities = Collections.emptyList();
			UserDetails userDetails = new CustomUserDetails(account.getUserId(), String.valueOf(account.getPassword()), account.getEnabled(), accountNonExpired, true, true, authorities);
			CustomUserDetails details = (CustomUserDetails) userDetails;
			details.setUserId(account.getUserId());
			return userDetails;
		}

	}

}
