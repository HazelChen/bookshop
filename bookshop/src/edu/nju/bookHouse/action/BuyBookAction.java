package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.BookInCart;
import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.DiscountCoupons;
import edu.nju.bookHouse.model.EqualCoupons;
import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.BookInCartService;
import edu.nju.bookHouse.service.CouponsService;
import edu.nju.bookHouse.service.OrderService;

public class BuyBookAction extends BaseAction{
	private static final long serialVersionUID = -6504775838432694009L;

	private static final String NOT_USE_STRING = "Not Use Now";
	
	private OrderService orderService;
	private CouponsService couponsService;
	private BookInCartService bookInCartService;
	
	@Override
	public String execute() {
		EqualCoupons equalCoupons = null;
		String equalSelected = request.getParameter("equalSelect");
		if (!equalSelected.equals(NOT_USE_STRING)) {
			equalCoupons = couponsService.getEqualCoupons(equalSelected);
		}
		
		DiscountCoupons discountCoupons = null;
		String discountSelected = request.getParameter("discountSelect");
		if (!discountSelected.equals(NOT_USE_STRING)) {
			discountCoupons = couponsService.getDiscountCoupons(discountSelected);
		}
		
		User user = (User) session.get("customer");
		CustomerInfo customerInfo = user.getCustomerInfo();
		List<BookInCart> bookInCarts = bookInCartService.getBookInCarts(customerInfo);
		
		String totalPrice = request.getParameter("totalPrice");
		orderService.takeAOrder(customerInfo, bookInCarts, equalCoupons, discountCoupons, totalPrice);
		bookInCartService.clear(customerInfo);
		return SUCCESS;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setCouponsService(CouponsService couponsService) {
		this.couponsService = couponsService;
	}

	public void setBookInCartService(BookInCartService bookInCartService) {
		this.bookInCartService = bookInCartService;
	}
}
