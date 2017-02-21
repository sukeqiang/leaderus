package mybatis.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mybatis.domain.LdHomeWorkFB;
import mybatis.domain.LdHomeWork;
import mybatis.domain.TBUser;
import mybatis.mapping.LdHomeWorkFBMapper;
import mybatis.mapping.LdHomeWorkMapper;
import mybatis.mapping.TBUserMapper;

@Component
@Transactional
public class UserService {

	@Autowired
	private TBUserMapper userMapper;
	
	@Autowired
	private LdHomeWorkMapper ldHomeWorkMapper;
	
	@Autowired
	private LdHomeWorkFBMapper ldHomeWorkFBMapper;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void createUser(TBUser user) {
		sqlSessionTemplate.insert("mybatis.mapping.TBUserMapper.insert", user);
	}
	
	public List<TBUser> getAllUsers() {
		return userMapper.selectAll();
	}
	
	public void saveOrUpdate(LdHomeWork ldHomeWork) {
		ldHomeWorkMapper.saveByOnDuplicateKeyUpdate(ldHomeWork);
	}
	
	public List<LdHomeWork> selectLdhomeworkByClassIdLessionId(Integer classId,Integer lessionId,
			String orderBy,String sortOrder) {
		return ldHomeWorkMapper.selectLdhomeworkByClassIdLessionId(classId,lessionId,orderBy,sortOrder);
	}
	
	public void getCommentHomeWork(LdHomeWorkFB comment, Integer homeworkId, int negativeStarFlag) {
		char bestFlag = '0';
		if(StringUtils.equalsIgnoreCase(comment.getLevelFlag(), "A")) {
			bestFlag = '1';
		}
		ldHomeWorkFBMapper.insert(comment);
		ldHomeWorkMapper.updateCommentByPrimaryKey(homeworkId, negativeStarFlag, bestFlag);
	}
	
	public List<LdHomeWorkFB> getAllComment(Integer homeworkId) {
		return ldHomeWorkFBMapper.selectByhomeworkId(homeworkId);
	}
}
