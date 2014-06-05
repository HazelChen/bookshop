package edu.nju.bookHouse.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import edu.nju.bookHouse.model.BuyBook;
import edu.nju.bookHouse.model.CustomerInfo;
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

	public List<OrderForm> getOrder(CustomerInfo customerInfo) {
		ArrayList<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("customerInfo", customerInfo));
		@SuppressWarnings("unchecked")
		List<OrderForm> orderForms = daoHelper.find(OrderForm.class, expressions);
		return orderForms;
	}
}
