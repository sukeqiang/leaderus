package myframework.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import myframework.service.AbstractService;
import userservice.bean.User;

@Component
public class UserService extends AbstractService<User> {

	@Override
	public void doCheckDomain(User user) {
		Assert.notNull(user, "user not null");
	}
}
