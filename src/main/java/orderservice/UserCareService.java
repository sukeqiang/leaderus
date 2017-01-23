package orderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserCareService {
	
	private final Logger logger = LoggerFactory.getLogger(UserCareService.class);
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@EventListener(condition = "#event == 'sendMessage'")
	public void notify(Object event) {
		publisher.publishEvent("messageHandler");
	}
}
