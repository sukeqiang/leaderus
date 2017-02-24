package mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mybatis.domain.LdHomeWorkFB;
import mybatis.domain.LdHomeWork;
import mybatis.domain.TBUser;
import mybatis.mapping.LdHomeWorkFBMapper;
import mybatis.mapping.LdHomeWorkMapper;
import mybatis.mapping.TBUserMapper;

@Component
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
	
	@Transactional
	public void saveCommentHomeWork(LdHomeWorkFB comment, int negativeStarFlag) {
		char bestFlag = '0';
		if(StringUtils.equalsIgnoreCase(comment.getLevelFlag(), "A")) {
			bestFlag = '1';
		}
		ldHomeWorkFBMapper.insert(comment);
		ldHomeWorkMapper.updateCommentByPrimaryKey(Integer.parseInt(comment.getHomeworkId().toString()), negativeStarFlag, bestFlag);
	}
	
	public List<LdHomeWorkFB> getAllComment(Integer homeworkId) {
		return ldHomeWorkFBMapper.selectByhomeworkId(homeworkId);
	}
}
