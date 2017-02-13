package mybatis.service;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import mybatis.domain.TBUser;
import mybatis.mapping.TBUserMapper;

@Component
@Transactional
public class UserService {

	@Autowired
	private TBUserMapper userMapper;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void createUser(TBUser user) {
		sqlSessionTemplate.insert("mybatis.mapping.TBUserMapper.insert", user);
//		userMapper.insert(user);
	}
	
	public List<TBUser> getAllUsers() {
		return userMapper.selectAll();
	}
}
