package launcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import trans.service.OperService;
import trans.service.QueryService;
import userservice.bean.User;

public class TransApp {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "liveConf");
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext("trans");
//		QueryService query = ctx.getBean(QueryService.class);
//		query.queryUser("000001");
		
//		User user = new User();
//		user.setUserName("mick");
		OperService oper = ctx.getBean(OperService.class);
//		oper.createUser(user);
//		oper.deleteUser(user);
//		oper.saveUser(user);
//		oper.updateUser(user);
//		ctx.close();
		
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 1; i < 3; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						User user = new User();
						user.setUserName("mick" + index);
						oper.createUser(user);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();  
				    }  
				}  
			});
		}
		fixedThreadPool.shutdown();
	}

}
