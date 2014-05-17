/**
 * 
 */
package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.user.IPasswordResetRequestRepository;
import in.anandm.apps.template.domain.model.user.PasswordResetRequest;
import in.anandm.apps.template.interfaces.web.helper.HashingUtility;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;

/**
 * @author anandm
 *
 */
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
		search.addFilter(Filter.equal("resetKey", HashingUtility.hexEncodedHash(resetKey.getBytes(), "SHA-512")));
		return searchUnique(search);
	}

}
