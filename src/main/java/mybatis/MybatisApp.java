package mybatis;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mybatis.TransConfig;
import mybatis.domain.LdHomeWork;
import mybatis.domain.LdHomeWorkFB;
import mybatis.domain.TBUser;

public class MybatisApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(TransConfig.class);
		TestUserService service = ctx.getBean(TestUserService.class);
//		TBUser user = new TBUser();
//		user.setUsername("ffff");
//		user.setPassword("123456");
//		service.testInsertUser(user);
//		LdHomeWork ldHomeWork = new LdHomeWork();
//		ldHomeWork.setBestFlag("11");
//		ldHomeWork.setCorrectFlag("03333");
//		ldHomeWork.setHomeworkFilename("filename");
//		ldHomeWork.setHomeworkFilepath("homeworkFilepath");
//		ldHomeWork.setNegativeCount(100);
//		ldHomeWork.setStarCount(70);
//		ldHomeWork.setUserId(6l);
//		ldHomeWork.setClassId(6l);
//		ldHomeWork.setLessionId(10l);
//		service.testLdHomeWork(ldHomeWork);
//		List<LdHomeWork> list = service.selectLdhomeworkByClassIdLessionId(6, 10, "create_date", "desc");
//		list.forEach((p)->System.out.println(p.getClassId() + " " + p.getUserId() + " " + p.getLessionId()+ " " + p.getHomeworkFilepath()));
//		ctx.close();
		LdHomeWorkFB comment = new LdHomeWorkFB();
		service.getCommentHomeWork(comment,4,1);
		service.getAllComment(4);
	}

}
