package fourthLessons.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import userservice.bean.User;
import userservice.bean.UserSession;
import userservice.interfaces.DataHandle;
import userservice.interfaces.Resource;

@Component
public class LdOrderService implements DataHandle<User>,Resource,BeanNameAware{

	private final Logger logger = LoggerFactory.getLogger(LdOrderService.class);
	
	public void createOrder() {
	}

	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean createUser(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean disableUser(long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> queryUsers(String userNamePrex, boolean onlyValidUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserSession login(String userName, String md5EncodedPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		
	}
}
