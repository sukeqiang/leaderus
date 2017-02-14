package launcher;

import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringBootApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootApp.class, args);
		Iterator<String> itors = ctx.getBeanFactory().getBeanNamesIterator();
		while (itors.hasNext()) {
		System.out.println(itors.next());
		}
	}

}
