package trans.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import userservice.bean.User;

@Component
public class OperService {

	private final Logger logger = LoggerFactory.getLogger(OperService.class);
	
	public void saveUser(User user) {
		logger.info("save user:" + user.getUserName());
	}
	
	public void updateUser(User user) {
		logger.info("update user:" + user.getUserName());
	}
	
	public void createUser(User user) {
		logger.info("create user:" + user.getUserName());
	}
	
	public void deleteUser(User user) {
		logger.info("delete user:" + user.getUserName());
	}
}
