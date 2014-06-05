package edu.nju.bookHouse.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.nju.bookHouse.dao.OrderDao;
import edu.nju.bookHouse.model.BookInCart;
import edu.nju.bookHouse.model.BuyBook;
import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.DiscountCoupons;
import edu.nju.bookHouse.model.EqualCoupons;
import edu.nju.bookHouse.model.OrderForm;

public class OrderService {
	private OrderDao orderDao;
	
	public void takeAOrder(CustomerInfo customerInfo, List<BookInCart> bookInCarts, 
			EqualCoupons equalCoupons, DiscountCoupons discountCoupons, String totalPriceString) {
		
		Set<EqualCoupons> equalCouponsSet = new HashSet<EqualCoupons>();
		Set<DiscountCoupons> discountCouponsSet = new HashSet<DiscountCoupons>();
		if (equalCoupons != null) {
			equalCouponsSet.add(equalCoupons);
		}
		if (discountCoupons != null) {
			discountCouponsSet.add(discountCoupons);
		}
		
		Date today = Calendar.getInstance().getTime();
		
		double totalPrice = Double.parseDouble(totalPriceString);
		OrderForm orderForm = new OrderForm(today, customerInfo, totalPrice, discountCouponsSet, equalCouponsSet);
		orderDao.add(orderForm);
		
		for (BookInCart bookInCart : bookInCarts) {
			BuyBook buyBook = new BuyBook(bookInCart.getBook(), bookInCart.getCount(), orderForm);
			orderDao.add(buyBook);
		} 
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
