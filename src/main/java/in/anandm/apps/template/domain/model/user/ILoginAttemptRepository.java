/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

/**
 * @author anandm
 *
 */
public interface ILoginAttemptRepository {

	void saveLoginAttempt(LoginAttempt loginAttempt);
}
