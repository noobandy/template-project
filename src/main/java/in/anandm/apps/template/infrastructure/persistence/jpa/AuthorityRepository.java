/**
 * 
 */
package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.authority.Authority;
import in.anandm.apps.template.domain.model.authority.IAuthorityRepository;
import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * @author anandm
 *
 */
@Repository
public class AuthorityRepository extends BaseRepository<Authority, Long> implements
IAuthorityRepository {

	@Override
	public void saveAuthority(Authority role) {
		save(role);
	}

	@Override

	public Authority getAuthorityByName(String authorityName) {

		return null;
	}

	@Override
	public DataTable<Authority> getDataTable(Map<String, String> params) {

		return getDataTable(Authority.class, params);
	}

}
