package trans4;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class MyLessionService {

	protected transient Log logger = LogFactory.getLog(getClass());
	
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name = "newMyLessionService")
	private NewMyLessionService newMyLessionService;
	
	public void addLession(String name, String price){
		jdbcTemplate.execute("insert into lession(name,price) values ('" + name + "','" + price + "')");
		newMyLessionService.addLession("mick1", "16.12");
	}
}
