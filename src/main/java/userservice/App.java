package userservice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import userservice.bean.User;
import userservice.config.LiveUserServiceConfig;
import userservice.config.TestUserServiceConfig;
import userservice.service.UserService;

public class App {

	public static void main(String[] args) {
		//自动加载不同环境配置文件
		System.setProperty("spring.profiles.active", "liveConf");
		System.setProperty("spring.profiles.default", "testConf");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("userservice") ;		
		//获取用户服务
		UserService service = ctx.getBean(UserService.class) ;
		//创建新用户
		User user = new User();
		user.setUserName("zhangsan");
		service.createUser(user);
		//查询用户
		service.queryUsers("zhangsan", true);
		//删除用户
		service.deleteUser(0l);
		//禁用用户
		service.disableUser(0l);
		
		ctx.close();
	}

}
