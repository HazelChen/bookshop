package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.OrderForm;
import edu.nju.bookHouse.model.State;
import edu.nju.bookHouse.service.OrderService;

public class ChangeStateAction extends BaseAction{
	private static final long serialVersionUID = -1171514158579045623L;
	
	private List<OrderForm> confirmedOrder;
	private List<OrderForm> distributedOrder;
	private List<OrderForm> sendedOrder;
	
	private OrderService orderService;
	
	public String show() {
		confirmedOrder = orderService.getOrder(State.CONFIRM);
		distributedOrder = orderService.getOrder(State.DISTRIBUTE);
		sendedOrder = orderService.getOrder(State.SEND);
		return SUCCESS;
	}
	
	public String changeStateToDistribute() {
		String orderId = request.getParameter("orderId");
		orderService.changeStateToDistribute(orderId);
		return SUCCESS;
	}
	
	public String changeStateToSend() {
		String orderId = request.getParameter("orderId");
		orderService.changeStateToSend(orderId);
		return SUCCESS;
	}

	public List<OrderForm> getConfirmedOrder() {
		return confirmedOrder;
	}

	public List<OrderForm> getDistributedOrder() {
		return distributedOrder;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public List<OrderForm> getSendedOrder() {
		return sendedOrder;
	}
}
