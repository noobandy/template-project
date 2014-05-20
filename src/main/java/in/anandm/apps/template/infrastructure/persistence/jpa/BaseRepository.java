/**
 * 
 */
package in.anandm.apps.template.infrastructure.persistence.jpa;

import in.anandm.apps.template.interfaces.web.facade.dto.ColumnMetaData;
import in.anandm.apps.template.interfaces.web.facade.dto.DataTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.Filter;
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
		
		Integer totalColumns = Integer.valueOf(params.get("iColumns"));
		String[] columnNames = params.get("sColumns").split(",");
		ColumnMetaData[] columnMetaDatas = new ColumnMetaData[totalColumns];
		
		for (Entry<String, String> entry : params.entrySet()) {
			String key = entry.getKey();
			String[] tokens = key.split("_");
			if(tokens.length > 1){
				String propPrefix = tokens[0];
				int columnIndex = Integer.valueOf(tokens[1]);
				
				ColumnMetaData columnMetaData = columnMetaDatas[columnIndex];
				
				
				if( columnMetaData == null){
					columnMetaData = new ColumnMetaData();
					columnMetaData.setColumnName(columnNames[columnIndex]);
				}
				
				if("bRegx".equals(propPrefix)){
					columnMetaData.setbRegx(Boolean.valueOf(entry.getValue()));
				}
				
				if("bSearchable".equals(propPrefix)){
					columnMetaData.setbSearchable(Boolean.valueOf(entry.getValue()));
				}
				
				if("bSortable".equals(propPrefix)){
					columnMetaData.setbSortable(Boolean.valueOf(entry.getValue()));
				}
				
				if("mDataProp".equals(propPrefix)){
					columnMetaData.setmDataProp(entry.getValue());
				}
				
				if("aSortDir".equals(propPrefix)){
					columnMetaData.setaSortDir(entry.getValue());
				}
				

				if("sSearch".equals(propPrefix)){
					columnMetaData.setsSearch(entry.getValue());
				}
				
				columnMetaDatas[columnIndex] = columnMetaData;
			}
			
			
		}

		Search search = new Search(entityClass);
		String searchText = params.get("sSearch");
		Integer sEcho = Integer.valueOf(params.get("sEcho"));
		Integer start = Integer.valueOf(params.get("iDisplayStart"));
		Integer noOfRecordsPerPage = Integer.valueOf(params.get("iDisplayLength"));
		
				
		List<Sort> sorts = new ArrayList<Sort>();
		List<Filter> filters = new ArrayList<Filter>();
		
		for (ColumnMetaData columnMetaData : columnMetaDatas) {
			if(searchText != null && !"".equals(searchText.trim()) && columnMetaData.getbSearchable()){
				filters.add(Filter.ilike(columnMetaData.getColumnName(), "%"+searchText+"%"));
			}
		}
		Filter[] filterArray = new Filter[filters.size()];
		
		search.addFilterOr(filters.toArray(filterArray));
		
		search.setFirstResult(start);
		search.setMaxResults(noOfRecordsPerPage);
		
		sorts.add(Sort.desc("userAccount.userId", true));
		search.setSorts(sorts);
		SearchResult<T> searchresult = _searchAndCount(search);

		DataTable<T> dataTable = new DataTable(sEcho, searchresult.getTotalCount(), searchresult.getTotalCount(), searchresult.getResult());
		return dataTable;
	}

}
