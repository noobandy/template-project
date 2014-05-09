/**
 * 
 */
package in.anandm.apps.template.application.impl;

import in.anandm.apps.template.application.dto.DataTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.SearchResult;
import com.googlecode.genericdao.search.Sort;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;

/**
 * @author anandm
 *
 */
@Repository
public class BaseRepository<T,ID extends Serializable> extends GenericDAOImpl<T, ID> {


	@Autowired
	@Override
	public void setSearchProcessor(JPASearchProcessor searchProcessor) {

		super.setSearchProcessor(searchProcessor);
	}

	@PersistenceContext
	@Override
	public void setEntityManager(EntityManager entityManager) {

		super.setEntityManager(entityManager);
	}

	public DataTable<T> getDataTable(Class<T> entityClass,Map<String, String> params){

		Search search = new Search(entityClass);
		String searchText = params.get("sSearch");
		Integer sEcho = Integer.valueOf(params.get("sEcho"));
		Integer start = Integer.valueOf(params.get("iDisplayStart"));
		Integer noOfRecordsPerPage = Integer.valueOf(params.get("iDisplayLength"));

		//search.addFetches(dataTableProperties);
		if(searchText != null && !"".equals(searchText.trim())){
			search.addFilterILike("userAccount.userId", searchText);
		}	
		search.setFirstResult(start);
		search.setMaxResults(noOfRecordsPerPage);
		List<Sort> sorts = new ArrayList<Sort>();
		sorts.add(Sort.desc("userAccount.userId", true));
		search.setSorts(sorts);
		SearchResult<T> searchresult = _searchAndCount(search);

		DataTable<T> dataTable = new DataTable(sEcho, searchresult.getTotalCount(), searchresult.getTotalCount(), searchresult.getResult());
		return dataTable;
	}

}
