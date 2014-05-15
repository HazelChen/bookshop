package edu.nju.bookHouse.service;

import java.util.Date;
import java.util.Calendar;


import edu.nju.bookHouse.dao.UserDao;
import edu.nju.bookHouse.model.Bank;
import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.Role;
import edu.nju.bookHouse.model.User;

public class UserService {
	private BankService bankService;
	private UserDao userDao;
	
	private DateChanger dateChanger;
	
	public User find(String username) {
		User user = userDao.find(username);
		return user;
	}
	
	public boolean exists(String username) {
		User user = find(username);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public User addCustomer(String username, String password, String sex, String address, String birthdayString, String bankId) {
		Calendar calendar = Calendar.getInstance();
		Date registerDay = calendar.getTime();
		
		Date birthDay = dateChanger.StringToDate(birthdayString);
		
		Bank bank = bankService.find(bankId); 
		
		CustomerInfo info = new CustomerInfo(username, sex, address, birthDay, registerDay, bank);
		User user = new User(username, password, Role.ROLE_CUSTOMER, info);
		userDao.add(user);
		return user;
	}
	
	public User loginVerify(String username, String password) {
		User user = userDao.find(username);
		if (user == null || !user.getPassword().equals(password)) {
			return null;
		}
		return user;
	}

	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setDateChanger(DateChanger dateChanger) {
		this.dateChanger = dateChanger;
	}
	
	
}
