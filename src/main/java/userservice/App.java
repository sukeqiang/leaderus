package userservice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import userservice.bean.User;
import userservice.config.LiveUserServiceConfig;
import userservice.config.TestUserServiceConfig;
import userservice.service.UserService;

public class App {

	public static void main(String[] args) {
		//�Զ����ز�ͬ���������ļ�
		System.setProperty("spring.profiles.active", "liveConf");
		System.setProperty("spring.profiles.default", "testConf");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("userservice") ;		
		//��ȡ�û�����
		UserService service = ctx.getBean(UserService.class) ;
		//�������û�
		User user = new User();
		user.setUserName("zhangsan");
		service.createUser(user);
		//��ѯ�û�
		service.queryUsers("zhangsan", true);
		//ɾ���û�
		service.deleteUser(0l);
		//�����û�
		service.disableUser(0l);
		
		ctx.close();
	}

}
