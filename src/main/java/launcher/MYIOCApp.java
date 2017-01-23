package launcher;

import java.math.BigDecimal;

import myframework.framework.context.LdIocFactory;
import myframework.service.AbstractService;
import myframework.service.impl.LDOrderService;
import myframework.service.impl.UserService;
import orderservice.LDOrder;
import userservice.bean.User;

public class MYIOCApp {
	
	public static void main(String[] args) {
		LdIocFactory factory = new LdIocFactory("myframework");
		//用户
		AbstractService<User> userservice = (AbstractService<User>)factory.getBean(UserService.class);
		User user = new User();
		user.setUserName("alice");
		userservice.saveDomain(user);
		userservice.deleteDomain(user);
		//订单
		AbstractService<LDOrder> ldorderservice = (AbstractService<LDOrder>)factory.getBean(LDOrderService.class);
		LDOrder order = new LDOrder();
		order.setOrderName("移动硬盘");
		order.setAmount(new BigDecimal(500.00));
		ldorderservice.saveDomain(order);
		ldorderservice.deleteDomain(order);
	}

}
