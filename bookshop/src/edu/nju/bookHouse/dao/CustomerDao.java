package edu.nju.bookHouse.dao;

import edu.nju.bookHouse.model.Customer;

public class CustomerDao {
	private DaoHelper daoHelper;
	
	public Customer find(String username) {
		return (Customer)daoHelper.findById(Customer.class, username);
	}
	
	public void add(Customer customer) {
		daoHelper.save(customer);
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}
	
	
}
