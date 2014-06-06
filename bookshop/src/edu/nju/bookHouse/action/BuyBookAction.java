package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.BookInCart;
import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.DiscountCoupons;
import edu.nju.bookHouse.model.EqualCoupons;
import edu.nju.bookHouse.model.OrderForm;
import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.BookInCartService;
import edu.nju.bookHouse.service.BookService;
import edu.nju.bookHouse.service.CouponsService;
import edu.nju.bookHouse.service.OrderService;

public class BuyBookAction extends BaseAction{
	private static final long serialVersionUID = -6504775838432694009L;

	private static final String NOT_USE_STRING = "Not Use Now";
	
	private OrderService orderService;
	private CouponsService couponsService;
	private BookInCartService bookInCartService;
	private BookService bookService;
	
	@Override
	public String execute() {
		//获得购物车信息
		User user = (User) session.get("customer");
		CustomerInfo customerInfo = user.getCustomerInfo();
		List<BookInCart> bookInCarts = bookInCartService.getBookInCarts(customerInfo);
		
		//减少库存
		bookService.reduceInventory(bookInCarts);
		
		//下订单
		String totalPrice = request.getParameter("totalPrice");
		OrderForm orderForm = orderService.takeAOrder(customerInfo, bookInCarts, totalPrice);
		
		//清空购物车
		bookInCartService.clear(customerInfo);
		
		//修改购物券信息
		EqualCoupons equalCoupons = null;
		String equalSelected = request.getParameter("equalSelect");
		if (!equalSelected.equals(NOT_USE_STRING)) {
			equalCoupons = couponsService.getEqualCoupons(equalSelected);
			couponsService.useEqualCoupons(equalCoupons, orderForm);
		}
		DiscountCoupons discountCoupons = null;
		String discountSelected = request.getParameter("discountSelect");
		if (!discountSelected.equals(NOT_USE_STRING)) {
			discountCoupons = couponsService.getDiscountCoupons(discountSelected);
			couponsService.useDiscountCoupons(discountCoupons, orderForm);
		}
		
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

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
