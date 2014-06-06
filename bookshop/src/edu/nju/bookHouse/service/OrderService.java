package edu.nju.bookHouse.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.nju.bookHouse.dao.OrderDao;
import edu.nju.bookHouse.model.BookInCart;
import edu.nju.bookHouse.model.BuyBook;
import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.OrderForm;

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
}
