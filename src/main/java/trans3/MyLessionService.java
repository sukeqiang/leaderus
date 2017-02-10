package trans3;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import trans.test.CustomTransException;

@Component
public class MyLessionService {

	protected transient Log logger = LogFactory.getLog(getClass());
	
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name = "newMyLessionService")
	private NewMyLessionService newMyLessionService;
	
	@Transactional(rollbackFor = CustomTransException.class,propagation = Propagation.REQUIRED)
	public void addLession(String name, String price){
		jdbcTemplate.execute("insert into lession(name,price) values ('" + name + "','" + price + "')");
		newMyLessionService.addLession("mick1", "16.12");
	}
}
