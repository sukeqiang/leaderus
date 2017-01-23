package fourthLessons.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;

import userservice.bean.User;

@Component
public class VipUserService {

	private final Logger logger = LoggerFactory.getLogger(VipUserService.class);
	
	private String name;
	private String id;
	private boolean isVip;
	private String email;
	private String phone;
	
	public void createVipUser(User user) {
		
	}
}
