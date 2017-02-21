package mybatis;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mybatis.domain.LdHomeWork;
import mybatis.domain.LdHomeWorkFB;
import mybatis.domain.TBUser;
import mybatis.service.UserService;

@Transactional
@Component
public class TestUserService {

	@Autowired
	private UserService userSrv;
	
	public void testInsertUser(TBUser user) {
		userSrv.createUser(user);
	}
	
	public void testLdHomeWork(LdHomeWork ldHomeWork) {
		userSrv.saveOrUpdate(ldHomeWork);
	}
	
	public List<LdHomeWork> selectLdhomeworkByClassIdLessionId(Integer classId,Integer lessionId,
			String orderBy,String sortOrder) {
		return userSrv.selectLdhomeworkByClassIdLessionId(classId,lessionId,orderBy,sortOrder);
	}
	
	public void getCommentHomeWork(LdHomeWorkFB comment, Integer homeworkId, int negativeStarFlag) {
		userSrv.getCommentHomeWork(comment, homeworkId, negativeStarFlag);
	}
	
	public List<LdHomeWorkFB> getAllComment(Integer homeworkId) {
		return userSrv.getAllComment(homeworkId);
	}
}
