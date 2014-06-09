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
import edu.nju.bookHouse.vo.OrderPromotionAnalyseVO;

public class OrderService {
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
	
	
}
