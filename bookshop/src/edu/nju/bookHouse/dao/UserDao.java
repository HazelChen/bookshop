package edu.nju.bookHouse.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.model.analyse.UserAddress;
import edu.nju.bookHouse.model.analyse.UserAge;
import edu.nju.bookHouse.model.analyse.UserGender;
import edu.nju.bookHouse.model.analyse.UserMonthAdd;

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
		List<?> userAddresses = sDaoHelper.findAll(UserAddress.class);
		sDaoHelper.removeAll(userAddresses);
		List<?> userAges = sDaoHelper.findAll(UserAge.class);
		sDaoHelper.removeAll(userAges);
		List<?> userGender = sDaoHelper.findAll(UserGender.class);
		sDaoHelper.removeAll(userGender);
		List<?> userMonthAdd = sDaoHelper.findAll(UserMonthAdd.class);
		sDaoHelper.removeAll(userMonthAdd);
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
	
	public void add(UserMonthAdd userMonthAdd) {
		sDaoHelper.save(userMonthAdd);
	}

	public long getRegisterDateCount(String minDateString, String maxDateString) {
		String hql = "select count(*) from edu.nju.bookHouse.model.CustomerInfo where registerDay>'" + minDateString + "' and registerDay<'" + maxDateString + "'";
		@SuppressWarnings("unchecked")
		List<Long> list = daoHelper.find(hql);
		if (list.size() == 0) {
			return 0;
		}
		return list.get(0);
	}

	public void setsDaoHelper(StaticsDaoHelper sDaoHelper) {
		this.sDaoHelper = sDaoHelper;
	}
	
	public List<UserMonthAdd> getAllUserMonthAdds() {
		@SuppressWarnings("unchecked")
		List<UserMonthAdd> monthAdds = sDaoHelper.findAll(UserMonthAdd.class);
		return monthAdds;
	}

	public List<UserAddress> getAllUserAddresses() {
		@SuppressWarnings("unchecked")
		List<UserAddress> userAddresses = sDaoHelper.findAll(UserAddress.class);
		return userAddresses;
	}

	public List<UserGender> getAllUserGenders() {
		@SuppressWarnings("unchecked")
		List<UserGender> userGenders = sDaoHelper.findAll(UserGender.class);
		return userGenders;
	}

	public List<UserAge> getAllUserAges() {
		@SuppressWarnings("unchecked")
		List<UserAge> userAges = sDaoHelper.findAll(UserAge.class);
		return userAges;
	}
	
	
}
