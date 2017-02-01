package trans.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QueryService {

	private final Logger logger = LoggerFactory.getLogger(QueryService.class);
	
	public void queryUser(String userId) {
		logger.info("query user!!");
	}
}
