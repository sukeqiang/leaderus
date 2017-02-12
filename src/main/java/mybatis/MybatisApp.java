package mybatis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mybatis.TransConfig;

public class MybatisApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(TransConfig.class);
		TestUserService service = ctx.getBean(TestUserService.class);
		service.testInsertUser();
		ctx.close();
		
	
	}

}
