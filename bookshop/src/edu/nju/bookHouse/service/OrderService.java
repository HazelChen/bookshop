package edu.nju.bookHouse.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.nju.bookHouse.dao.OrderDao;
import edu.nju.bookHouse.model.BookInCart;
import edu.nju.bookHouse.model.BuyBook;
import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.OrderForm;
import edu.nju.bookHouse.model.State;
import edu.nju.bookHouse.model.analyse.DaySales;
import edu.nju.bookHouse.model.analyse.OrderShipment;
import edu.nju.bookHouse.vo.OrderPromotionAnalyseVO;
import edu.nju.bookHouse.vo.OrderShipmentAvgVO;

public class OrderService {
	private DateChanger dateChanger;
	
	private OrderDao orderDao;
	
	public OrderForm takeAOrder(CustomerInfo customerInfo, List<BookInCart> bookInCarts, String totalPriceString) {
		Date today = Calendar.getInstance().getTime();
		
		double totalPrice = Double.parseDouble(totalPriceString);
		OrderForm orderForm = new OrderForm(today, customerInfo, totalPrice);
		orderDao.add(orderForm);
		
		for (BookInCart bookInCart : bookInCarts) {
			BuyBook buyBook = new BuyBook(bookInCart.getBook(), bookInCart.getCount(), orderForm);
			orderDao.add(buyBook);
		}
		return orderForm;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public List<OrderForm> getOrder(CustomerInfo customerInfo) {
		return orderDao.getOrder(customerInfo);
	}

	public List<OrderForm> getOrder(State state) {
		return orderDao.getOrder(state);
	}

	public void changeStateToDistribute(String orderId) {
		int id = Integer.parseInt(orderId);
		OrderForm orderForm = orderDao.find(id);
		orderForm.setState(State.DISTRIBUTE);
		
		Date today = Calendar.getInstance().getTime();
		orderForm.setDistributeDate(today);
		
		orderDao.update(orderForm);
	}

	public void changeStateToSend(String orderId) {
		int id = Integer.parseInt(orderId);
		OrderForm orderForm = orderDao.find(id);
		orderForm.setState(State.SEND);
		
		Date today = Calendar.getInstance().getTime();
		orderForm.setSendDate(today);
		
		orderDao.update(orderForm);
	}

	public OrderPromotionAnalyseVO getPromotionSales() {
		String mediateDateString = "2014-6-1";
		int beforeCount = (int) orderDao.getOrderBeforeDate(mediateDateString);
		int afterCount = (int) orderDao.getOrderAfterDate(mediateDateString);
		double rate = ((int)((afterCount - beforeCount + 0.0) / beforeCount * 100)) / 100.0;
		OrderPromotionAnalyseVO vo = new OrderPromotionAnalyseVO(beforeCount, afterCount, rate);
		return vo;
	}
	
	public void analyse() {
		orderDao.removeAllStatics();
		daySalesAnalyse();
		shipmentAnalyse();
	}
	
	private void shipmentAnalyse() {
		List<OrderForm> orderForms = orderDao.getAllOrders();
		for (OrderForm orderForm : orderForms) {
			Date comfirmDate = orderForm.getConfirmDate();
			Date distributeDate = orderForm.getDistributeDate();
			Date sendDate = orderForm.getSendDate();
			
			OrderShipment orderShipment = new OrderShipment(orderForm.getId());
			if (distributeDate == null) {
				break;
			} else {
				int distributeDay = dateDiff(comfirmDate, distributeDate);
				orderShipment.setDistributeDay(distributeDay);
			}
			
			if (sendDate == null) {
				orderDao.add(orderShipment);
				break;
			} else {
				int sendDay = dateDiff(distributeDate, sendDate);
				orderShipment.setSendDay(sendDay);
				orderDao.add(orderShipment);
			}
			
		}
	}
	
	private int dateDiff(Date minDate, Date maxDate) {
		return (int) ((maxDate.getTime() - minDate.getTime()) / (24 * 60 * 60 * 1000));
	}

	private void daySalesAnalyse() {
		Calendar calendar = Calendar.getInstance();
		long nowTime = calendar.getTimeInMillis();
		calendar.set(2014, 4, 20);
		long firstTime = calendar.getTimeInMillis();
		int diffDay = (int) ((nowTime - firstTime) / (1000 * 3600 * 24));
		
		for (int i = 0; i <= diffDay; i++) {
			Date date = calendar.getTime();
			String dateString = dateChanger.normalDateToString(date);
			int count = (int) orderDao.getCountAtDate(dateString);
			DaySales daySales = new DaySales(count);
			orderDao.add(daySales);
			calendar.add(Calendar.DATE, 1);
		}
	}

	public void setDateChanger(DateChanger dateChanger) {
		this.dateChanger = dateChanger;
	}

	public List<DaySales> getAllDaySales() {
		return orderDao.getAllDaySales();
	}
	
	public List<OrderShipment> getAllOrderShipments() {
		return orderDao.getAllOrderShipment();
	}

	public OrderShipmentAvgVO calShipmentAvg(List<OrderShipment> orderShipments) {
		int totalDistributeDay = 0;
		int totalSendDay = 0;
		for (OrderShipment orderShipment : orderShipments) {
			totalDistributeDay += orderShipment.getDistributeDay();
			totalSendDay += orderShipment.getSendDay();
		}
		int size = orderShipments.size();
		double avgDistribute = ((int)((totalDistributeDay + 0.0) / size * 100)) / 100.0;
		double avgSend = ((int)((totalSendDay + 0.0) / size * 100)) / 100.0;
		OrderShipmentAvgVO vo = new OrderShipmentAvgVO(avgDistribute, avgSend);
		return vo;
	}
}
