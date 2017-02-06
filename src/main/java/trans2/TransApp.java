package trans2;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import trans2.conf.TransConfig;
import trans2.service.LessionService;

public class TransApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(TransConfig.class);
		LessionService oper = ctx.getBean(LessionService.class);
		oper.saveService("alice", "155.11");
		ctx.close();
		
	}

}
