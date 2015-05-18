/**
 * 
 */
package in.anandm.apps.template.domain.service;


/**
 * @author anandm
 * 
 */
public interface SecurityContextHelper {

	boolean isAuthenticated();

	String[] getGrantedAuthorities();
}
