/**
 * 
 */
package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.application.impl.UserRepository;
import in.anandm.apps.template.domain.model.user.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.Sort;

/**
 * @author anandm
 *
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(User user){
		userRepository.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getRecords(Integer start, Integer noOfRecordsPerPage,
			String searchText) {
		Search search = new Search(User.class);
		if(searchText != null && !"".equals(searchText.trim())){
			search.addFilterILike("userName", searchText);
		}	
		search.setFirstResult(start);
		search.setMaxResults(noOfRecordsPerPage);
		List<Sort> sorts = new ArrayList<Sort>();
		sorts.add(Sort.desc("userName", true));
		search.setSorts(sorts);
		search.setResultMode(Search.RESULT_LIST);
		return userRepository.search(search);
	}


}
