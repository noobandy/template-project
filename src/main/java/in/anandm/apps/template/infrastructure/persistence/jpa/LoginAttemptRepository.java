/**
 * 
 */
package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.user.ILoginAttemptRepository;
import in.anandm.apps.template.domain.model.user.LoginAttempt;

import org.springframework.stereotype.Repository;

/**
 * @author anandm
 *
 */
@Repository
public class LoginAttemptRepository extends BaseRepository<LoginAttempt, Long> implements ILoginAttemptRepository {

	public void saveLoginAttempt(LoginAttempt loginAttempt){
		save(loginAttempt);
	}
}
