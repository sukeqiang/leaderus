package myframework.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import myframework.dao.AbstractDao;
import userservice.bean.User;

@Component
public class UserDao extends AbstractDao<User> {

	private final Logger logger = (Logger) LoggerFactory.getLogger(UserDao.class);
	
	@Override
	public boolean createDomainObj(User user) {
		Assert.notNull(user, "user not null");
		logger.info("create user [name]:" + user.getUserName());
		return super.createDomainObj(user);
	}

	@Override
	public boolean deleteDomainObj(User user) {
		Assert.notNull(user, "user not null");
		logger.info("delete user [name]:" + user.getUserName());
		return super.deleteDomainObj(user);
	}
}
