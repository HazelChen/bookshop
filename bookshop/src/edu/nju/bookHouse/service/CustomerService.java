package edu.nju.bookHouse.service;

import java.util.Date;
import java.util.Calendar;

import org.jboss.resteasy.util.FindAnnotation;

import edu.nju.bookHouse.dao.CustomerDao;
import edu.nju.bookHouse.model.Bank;
import edu.nju.bookHouse.model.Customer;

public class CustomerService {
	private BankService bankService;
	private CustomerDao customerDao;
	
	private DateChanger dateChanger;
	
	public Customer find(String username) {
		Customer customer = customerDao.find(username);
		return customer;
	}
	
	public boolean exists(String username) {
		Customer customer = find(username);
		if (customer == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public void addCustomer(String username, String password, String sex, String address, String birthdayString, String bankId) {
		Calendar calendar = Calendar.getInstance();
		Date registerDay = calendar.getTime();
		
		Date birthDay = dateChanger.StringToDate(birthdayString);
		
		Bank bank = bankService.find(bankId); 
		
		Customer customer = new Customer(username, password, sex, address, birthDay, registerDay, bank);
		customerDao.add(customer);
	}

	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setDateChanger(DateChanger dateChanger) {
		this.dateChanger = dateChanger;
	}
	
	
}
