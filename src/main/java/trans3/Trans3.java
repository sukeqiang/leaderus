package trans3;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import trans3.TransConfig;
import trans3.MyLessionService;

public class Trans3 {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransConfig.class);
		MyLessionService service = ctx.getBean(MyLessionService.class);
		service.addLession("mick", "13.00");
		ctx.close();
	}
}
