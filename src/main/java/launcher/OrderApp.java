package launcher;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import orderservice.LDOrder;
import orderservice.LdOrderService;
import userservice.bean.User;

public class OrderApp{

	public static void main(String[] args) throws Exception{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("orderservice");
		LdOrderService orderService=ctx.getBean(LdOrderService.class) ;
		User user = new User();
		user.setUserName("alice");
		LDOrder order = new LDOrder();
		order.setAmount(new BigDecimal(501.00));
		order.setOrderName("TOSHIBA 移动硬盘 1T");
		order.setUser(user);
		
		orderService.createOrder(order);
		
		ctx.close();
	}

}
