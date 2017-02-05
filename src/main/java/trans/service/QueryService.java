package trans.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


@Component
public class QueryService {

	protected static transient Log logger = LogFactory.getLog(QueryService.class);
	
	public void queryUser(String userId) {
		logger.info("query user!!");
	}
}
