package edu.nju.bookHouse.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.model.UserAddress;
import edu.nju.bookHouse.model.UserAge;
import edu.nju.bookHouse.model.UserGender;

public class UserDao {
	private DaoHelper daoHelper;
	private StaticsDaoHelper sDaoHelper;
	
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

	public List<Object[]> getUserAddressObject() {
		String hql = "select address,count(*) from edu.nju.bookHouse.model.CustomerInfo group by address";
		@SuppressWarnings("unchecked")
		List<Object[]> list = daoHelper.find(hql);
		return list;
	}
	
	public void add(UserAddress userAddress) {
		sDaoHelper.save(userAddress);
	}
	
	public void removeAllStatics() {
		sDaoHelper.deleteAll("edu.nju.bookHouse.model.UserAddress");
		sDaoHelper.deleteAll("edu.nju.bookHouse.model.UserAge");
		sDaoHelper.deleteAll("edu.nju.bookHouse.model.UserGender");
		sDaoHelper.deleteAll("edu.nju.bookHouse.model.UserMonthAdd");
	}

	public long getAgeCount(String minYear, String maxYear) {
		String hql = "select count(*) from edu.nju.bookHouse.model.CustomerInfo where birthday >= '" + minYear + "' and birthday < '" + maxYear + "'";
		@SuppressWarnings("unchecked")
		List<Long> list = daoHelper.find(hql);
		if (list.size() == 0) {
			return 0;
		}
		return list.get(0);
	}
	
	public void add(UserAge userAge) {
		sDaoHelper.save(userAge);
	}
	
	public long getMaleCount() {
		String hql = "select count(*) from edu.nju.bookHouse.model.CustomerInfo where gender='MALE'";
		@SuppressWarnings("unchecked")
		List<Long> list = daoHelper.find(hql);
		if (list.size() == 0) {
			return 0;
		}
		return list.get(0);
	}
	
	public long getFemaleCount() {
		String hql = "select count(*) from edu.nju.bookHouse.model.CustomerInfo where gender='FEMALE'";
		@SuppressWarnings("unchecked")
		List<Long> list = daoHelper.find(hql);
		if (list.size() == 0) {
			return 0;
		}
		return list.get(0);
	}
	
	public void add(UserGender userGender) {
		sDaoHelper.save(userGender);
	}
}
