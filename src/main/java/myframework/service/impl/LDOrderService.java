package myframework.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import myframework.service.AbstractService;
import orderservice.LDOrder;

@Component
public class LDOrderService extends AbstractService<LDOrder> {

	@Override
	public void doCheckDomain(LDOrder order) {
		Assert.notNull(order, "order not null");
	}

	
}
