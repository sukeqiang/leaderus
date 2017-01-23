package myframework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import myframework.dao.AbstractDao;

public class AbstractService<T> {

	private final Logger logger = (Logger) LoggerFactory.getLogger(AbstractService.class);
	
	@Autowired
	private AbstractDao<T> abstractDao;
	
	public boolean saveDomain(T domain) {
		logger.info("check domain obj " + domain);
		doCheckDomain(domain);
		logger.info("save domain obj " + domain);
		abstractDao.createDomainObj(domain);
		return true;
	}
	
	public boolean deleteDomain(T domain) {
		logger.info("check domain obj " + domain);
		doCheckDomain(domain);
		logger.info("delete domain obj " + domain);
		abstractDao.deleteDomainObj(domain);
		return true;
	}
	
	protected void doCheckDomain(T domain) {};
	
}
