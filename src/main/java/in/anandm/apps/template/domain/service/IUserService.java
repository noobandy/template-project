package in.anandm.apps.template.domain.service;

import in.anandm.apps.template.domain.model.user.User;

import org.springframework.transaction.annotation.Transactional;

public interface IUserService {

	@Transactional
	void addUser(User user);

}