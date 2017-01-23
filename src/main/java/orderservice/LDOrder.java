package orderservice;

import java.math.BigDecimal;

import userservice.bean.User;

public class LDOrder {
	
	private String orderName;
	
	private BigDecimal Amount;
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public BigDecimal getAmount() {
		return Amount;
	}

	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}
}
