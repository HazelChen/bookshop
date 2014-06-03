package edu.nju.bookHouse.action;

import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.CollectedBookService;

public class CollectBookAction extends BaseAction{
	private static final long serialVersionUID = 3445805211829776365L;
	
	private CollectedBookService collectedBookService;

	@Override
	public String execute() {
		String bookId = request.getParameter("bookId");
		User user = (User) session.get("customer");
		int customerId = user.getCustomerInfo().getId();
		
		collectedBookService.addCollectedBook(bookId, customerId);
		return SUCCESS;
	}

	public void setCollectedBookService(CollectedBookService collectedBookService) {
		this.collectedBookService = collectedBookService;
	}
}
