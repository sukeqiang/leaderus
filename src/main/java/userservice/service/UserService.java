package userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import userservice.bean.User;
import userservice.bean.UserSession;
import userservice.interfaces.DataHandle;

@Component
public class UserService {

	@Autowired
	private DataHandle<User> dataHandle ;

	public boolean createUser(User user) {
		return dataHandle.createUser(user);
	}

	public boolean deleteUser(long userId) {
		return dataHandle.deleteUser(userId);
	}

	public boolean disableUser(long userId) {
		return dataHandle.disableUser(userId);
	}

	public List<User> queryUsers(String userNamePrex, boolean onlyValidUser) {
		return dataHandle.queryUsers(userNamePrex, onlyValidUser);
	}

	public UserSession login(String userName, String md5EncodedPassword) {
		UserSession session = dataHandle.login(userName, md5EncodedPassword) ;
		return session;
	}
}
