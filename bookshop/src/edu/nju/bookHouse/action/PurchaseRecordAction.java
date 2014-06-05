package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.OrderForm;
import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.OrderService;

public class PurchaseRecordAction extends BaseAction{
	private static final long serialVersionUID = 9101535110872645516L;

	private List<OrderForm> orders;
	
	private OrderService orderService;
	
	@Override
	public String execute() {
		User user = (User)session.get("customer");
		CustomerInfo customerInfo = user.getCustomerInfo();
		orders = orderService.getOrder(customerInfo);
		return SUCCESS;
	}

	public List<OrderForm> getOrders() {
		return orders;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
}
