package trans3;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import trans.test.CustomTransException;

@Component(value = "newMyLessionService")
public class NewMyLessionService {

	protected transient Log logger = LogFactory.getLog(getClass());
	
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(rollbackFor = CustomTransException.class,propagation = Propagation.NESTED)
	public void addLession(String name, String price)throws CustomTransException{
		jdbcTemplate.execute("insert into lession(name,price) values ('" + name + "','" + price + "')");
		throw new CustomTransException("aaaaaa");
	}
}
