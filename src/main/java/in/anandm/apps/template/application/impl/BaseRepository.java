/**
 * 
 */
package in.anandm.apps.template.application.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
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

	
}
