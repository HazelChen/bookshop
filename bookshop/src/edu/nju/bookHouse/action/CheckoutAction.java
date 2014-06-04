package edu.nju.bookHouse.action;

import java.util.ArrayList;
import java.util.Set;

import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.BookInCart;
import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.DiscountCoupons;
import edu.nju.bookHouse.model.EqualCoupons;
import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.BookInCartService;
import edu.nju.bookHouse.service.UserService;

public class CheckoutAction extends BaseAction{
	private static final long serialVersionUID = 7248761943184459513L;
	
	private ArrayList<Book> cartBooks;
	private ArrayList<BookInCart> bookInCarts;
	private double totalPrice;
	private Set<EqualCoupons> equalCoupons;
	private Set<DiscountCoupons> discountCoupons;
	
	private BookInCartService bookInCartService;
	private UserService userService;
	
	@Override
	public String execute() {
		User sessionUser = (User)session.get("customer");
		String userId = sessionUser.getUsername();
		User user = userService.find(userId);
		CustomerInfo customerInfo = user.getCustomerInfo();
		cartBooks = new ArrayList<Book>();
		cartBooks.addAll(customerInfo.getBooksInShoppingCart());
		equalCoupons = customerInfo.getEqualCoupons();
		discountCoupons = customerInfo.getDiscountCoupons();
		
		bookInCarts = bookInCartService.getBookInCarts(customerInfo.getId(), cartBooks);
		
		totalPrice = bookInCartService.totalPrice(bookInCarts);
		return SUCCESS;
	}

	public void setBookInCartService(BookInCartService bookInCartService) {
		this.bookInCartService = bookInCartService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ArrayList<Book> getCartBooks() {
		return cartBooks;
	}

	public ArrayList<BookInCart> getBookInCarts() {
		return bookInCarts;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public Set<EqualCoupons> getEqualCoupons() {
		return equalCoupons;
	}

	public Set<DiscountCoupons> getDiscountCoupons() {
		return discountCoupons;
	}
}
