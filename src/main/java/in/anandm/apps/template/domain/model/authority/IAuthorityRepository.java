/**
 * 
 */
package in.anandm.apps.template.domain.model.authority;

import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author anandm
 *
 */
public interface IAuthorityRepository {


	@Transactional
	void saveAuthority(Authority role);

	@Transactional(readOnly=true)
	Authority getAuthorityByName(String authorityName);

	@Transactional(readOnly=true)
	DataTable<Authority> getDataTable(Map<String, String> params);
}
