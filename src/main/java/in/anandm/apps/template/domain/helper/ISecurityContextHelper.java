/**
 * 
 */
package in.anandm.apps.template.domain.helper;

import in.anandm.apps.template.domain.model.authority.Authority;
import in.anandm.apps.template.domain.model.user.User;

import java.util.Collection;

/**
 * @author anandm
 *
 */
public interface ISecurityContextHelper {

	User authenticatedUser();
	Collection<Authority> getAuthorities();

}
