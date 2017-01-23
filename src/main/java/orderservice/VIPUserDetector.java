package orderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import userservice.bean.User;

@Component
public class VIPUserDetector {
	
	private final Logger logger = LoggerFactory.getLogger(VIPUserDetector.class);
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@EventListener(condition = "#order.Amount>500")
	public void vipUserDetectorHandlerEvent(LDOrder order) {
		logger.info("create order:".concat(order.getOrderName()));
		publisher.publishEvent(order.getUser());
	}
}
