package myframework.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import myframework.dao.AbstractDao;
import orderservice.LDOrder;

@Component
public class LDOrderDao extends AbstractDao<LDOrder> {

	private final Logger logger = LoggerFactory.getLogger(LDOrderDao.class);
	
	@Override
	public boolean createDomainObj(LDOrder order) {
		Assert.notNull(order, "order not null");
		logger.info("create order [name]:" + order.getOrderName() 
		+ " [price]:" + order.getAmount().toString());
		return super.createDomainObj(order);
	}

	@Override
	public boolean deleteDomainObj(LDOrder order) {
		Assert.notNull(order, "order not null");
		logger.info("delete order [name]:" + order.getOrderName());
		return super.deleteDomainObj(order);
	}

}
