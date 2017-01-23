package orderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	private final Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	@EventListener(condition = "#event == 'messageHandler'")
	public void sendEmail(Object event) {
		logger.info("send email successed");
	}
}
