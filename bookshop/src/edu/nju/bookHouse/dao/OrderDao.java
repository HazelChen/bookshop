package edu.nju.bookHouse.dao;

import edu.nju.bookHouse.model.BuyBook;
import edu.nju.bookHouse.model.OrderForm;

public class OrderDao {
	private DaoHelper daoHelper;
	
	public void add(OrderForm orderForm) {
		daoHelper.save(orderForm);
	}
	
	public void add(BuyBook book) {
		daoHelper.save(book);
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}
}
