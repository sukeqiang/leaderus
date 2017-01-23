package launcher;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fourthLessons.mockTest.pojo.TCourse;
import fourthLessons.mockTest.service.MyCoureseService;

public class BeanProcessorApp {
	
	private static final Logger logger = LoggerFactory.getLogger(BeanProcessorApp.class);

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "liveConf");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("fourthLessons");
		MyCoureseService service = ctx.getBean(MyCoureseService.class);
		try {
			List<TCourse> list = service.getAllCourse();
			logger.info("course mark:");
			for(TCourse course : list) {
				logger.info(course.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ctx.close();
	}

}
