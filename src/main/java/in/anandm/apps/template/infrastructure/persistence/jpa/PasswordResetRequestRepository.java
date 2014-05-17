/**
 * 
 */
package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.user.IPasswordResetRequestRepository;
import in.anandm.apps.template.domain.model.user.PasswordResetRequest;

import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

/**
 * @author anandm
 *
 */
@Repository
public class PasswordResetRequestRepository extends BaseRepository<PasswordResetRequest, Long>
implements IPasswordResetRequestRepository {

	@Override
	public void savePasswordResetRequest(
			PasswordResetRequest passwordResetRequest) {
		save(passwordResetRequest);
	}

	@Override
	public PasswordResetRequest getPasswordResetRequestByKey(String resetKey) {
		Search search = new Search(PasswordResetRequest.class);
		search.addFilter(Filter.equal("resetKey", resetKey));
		return searchUnique(search);
	}

}
