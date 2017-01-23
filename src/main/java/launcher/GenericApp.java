package launcher;

import myframework.service.AbstractService;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import myframework.service.impl.LDOrderService;
import myframework.service.impl.UserService;
import orderservice.LDOrder;
import userservice.bean.User;

/*
 * 需要把UserService,LDOrderService LDOrderDao,UserDao替换成spring的@Component,@Autowired才可以运行，默认用的注解是自己声明的
 */
public class GenericApp {

	public static void main(String[] args) {
		//需要把UserService,LDOrderService LDOrderDao,UserDao替换成spring的@Component,@Autowired才可以运行，默认用的注解是自己声明的
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("myframework");
		//用户
		AbstractService<User> userservice = ctx.getBean(UserService.class);
		User user = new User();
		user.setUserName("alice");
		userservice.saveDomain(user);
		userservice.deleteDomain(user);
		//订单
		AbstractService<LDOrder> ldorderservice = ctx.getBean(LDOrderService.class);
		LDOrder order = new LDOrder();
		order.setOrderName("移动硬盘");
		order.setAmount(new BigDecimal(500.00));
		ldorderservice.saveDomain(order);
		ldorderservice.deleteDomain(order);
		ctx.close();
	}

}
