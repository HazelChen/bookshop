package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.analyse.DaySales;
import edu.nju.bookHouse.model.analyse.OrderShipment;
import edu.nju.bookHouse.service.OrderService;
import edu.nju.bookHouse.vo.OrderShipmentAvgVO;

public class OrderAnalyseAction extends BaseAction{
	private static final long serialVersionUID = -1197645590531794305L;
	
	private List<DaySales> daySales;
	private List<OrderShipment> orderShipments;
	private double distributedDayAvg;
	private double sendDayAvg;
	
	private OrderService orderService;
	
	@Override
	public String execute() {
		daySales = orderService.getAllDaySales();
		orderShipments = orderService.getAllOrderShipments();
		OrderShipmentAvgVO vo = orderService.calShipmentAvg(orderShipments);
		distributedDayAvg = vo.distributedDayAvg;
		sendDayAvg = vo.sendDayAvg;
		return SUCCESS;
	}

	public List<DaySales> getDaySales() {
		return daySales;
	}

	public List<OrderShipment> getOrderShipments() {
		return orderShipments;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public double getDistributedDayAvg() {
		return distributedDayAvg;
	}

	public double getSendDayAvg() {
		return sendDayAvg;
	}

}
