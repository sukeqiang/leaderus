package trans5;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import trans.test.CustomTransException;

@Component
public class MyServiceA {

	protected transient Log logger = LogFactory.getLog(getClass());
	
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name = "recordService")
	private RecordService recordService;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void dobusiness(){
		
	}
}
