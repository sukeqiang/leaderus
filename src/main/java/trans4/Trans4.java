package trans4;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import trans4.TransConfig;
import trans4.MyLessionService;

public class Trans4 {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransConfig.class);
		MyLessionService service = ctx.getBean(MyLessionService.class);
		service.addLession("mick", "13.00");
		ctx.close();
	}
}
