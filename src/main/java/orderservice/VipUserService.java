package orderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import userservice.bean.User;

@Component
public class VipUserService {

	private final Logger logger = LoggerFactory.getLogger(VipUserService.class);
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@EventListener
	public void createVipUser(User user) {
		user.setVip(true);
		logger.info("create vip user:".concat(user.getUserName()));
		publisher.publishEvent("sendMessage");
	}
}
