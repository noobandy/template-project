/**
 * 
 */
package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.domain.model.authority.Authority;
import in.anandm.apps.template.domain.model.authority.IAuthorityRepository;
import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author anandm
 * 
 */
@Repository
public class AuthorityRepository extends BaseRepository<Authority, String>
		implements IAuthorityRepository {

	@Override
	public void saveAuthority(Authority authority) {
		save(authority);
	}

	@Override
	public Authority findAuthorityByName(String authorityName) {

		return find(authorityName);
	}

	@Override
	public DataTable<Authority> getDataTable(Map<String, String> params) {

		return getDataTable(Authority.class, params);
	}

	@Override
	public List<Authority> findAllAuthorities() {

		return findAll();
	}

	@Override
	public void removeAuthorityByName(String authorityName) {
		removeById(authorityName);

	}

	@Override
	@Transactional
	public List<Authority> findAuthoritiesByName(String[] authorityNames) {

		return Arrays.asList(find(authorityNames));
	}

}
