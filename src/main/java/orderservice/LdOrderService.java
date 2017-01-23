package orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class LdOrderService {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	public void createOrder(LDOrder order) {
		publisher.publishEvent(order);
	}
}
