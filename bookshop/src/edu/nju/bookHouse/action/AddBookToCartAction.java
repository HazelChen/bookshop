package edu.nju.bookHouse.action;

import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.BookInCartService;

public class AddBookToCartAction extends BaseAction{
	private static final long serialVersionUID = -1513200429428511312L;
	
	private BookInCartService bookInCartService;
	
	@Override
	public String execute() {
		String bookId = request.getParameter("bookId");
		User user = (User) session.get("customer");
		int customerId = user.getCustomerInfo().getId();

		bookInCartService.add(bookId, customerId);
		return SUCCESS;
	}

	public void setBookInCartService(BookInCartService bookInCartService) {
		this.bookInCartService = bookInCartService;
	}
}
