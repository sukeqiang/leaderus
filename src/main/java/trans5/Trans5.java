package trans5;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import trans3.TransConfig;
import trans3.MyLessionService;

public class Trans5 {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransConfig.class);
		
		ctx.close();
	}
}
