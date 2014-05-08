package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.domain.model.user.User;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface IUserService {

	@Transactional
	void addUser(User user);

	@Transactional(readOnly=true)
	List<User> getRecords(Integer start,Integer noOfRecordsPerPage,String searchText);
}