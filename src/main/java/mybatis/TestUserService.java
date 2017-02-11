package mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mybatis.domain.TBUser;
import mybatis.service.UserService;

@Transactional
@Component
public class TestUserService {

	@Autowired
	private UserService userSrv;
	
	public void testInsertUser() {
		TBUser user = new TBUser();
		user.setUsername("ffff");
		user.setPassword("123456");
		userSrv.createUser(user);
	}
}
