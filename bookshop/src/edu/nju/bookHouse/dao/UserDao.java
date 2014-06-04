package edu.nju.bookHouse.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.User;

public class UserDao {
	private DaoHelper daoHelper;
	
	public User find(String username) {
		return (User)daoHelper.findById(User.class, username);
	}
	
	public void add(User user) {
		daoHelper.save(user);
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllCustomers() {
		Criterion ctriterion = Restrictions.isNotNull("customerInfo");
		List<User> users = daoHelper.find(User.class, ctriterion);
		return users;
	}

	public CustomerInfo findCustomerInfo(int customerId) {
		return (CustomerInfo) daoHelper.findById(CustomerInfo.class, customerId);
	}
}
