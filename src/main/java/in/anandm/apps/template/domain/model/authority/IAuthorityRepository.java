/**
 * 
 */
package in.anandm.apps.template.domain.model.authority;

import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.List;
import java.util.Map;

/**
 * @author anandm
 * 
 */
public interface IAuthorityRepository {

	
	void saveAuthority(Authority authority);

	
	List<Authority> findAllAuthorities();

	
	Authority findAuthorityByName(String authorityName);

	
	List<Authority> findAuthoritiesByName(String[] authorityNames);

	
	void removeAuthorityByName(String authorityName);

	
	DataTable<Authority> getDataTable(Map<String, String> params);
}
