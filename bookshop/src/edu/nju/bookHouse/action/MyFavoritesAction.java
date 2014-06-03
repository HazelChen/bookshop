package edu.nju.bookHouse.action;

import java.util.Set;

import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.UserService;

public class MyFavoritesAction extends BaseAction{
	private static final long serialVersionUID = 6022296981997441482L;

	private Set<Book> bookCollected;
	
	private UserService userService;
	
	@Override
	public String execute() {
		String userId = ((User)(session.get("customer"))).getUsername();
		
		User user = userService.find(userId);
		bookCollected = user.getCustomerInfo().getBooksCollected();
		return SUCCESS;
	}

	public Set<Book> getBookCollected() {
		return bookCollected;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
