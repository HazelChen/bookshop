package edu.nju.bookHouse.dao;

import edu.nju.bookHouse.model.Bank;

public class BankDao {
	private DaoHelper daoHelper;
	
	public Bank find(String bankId) {
		Bank bank = (Bank) daoHelper.findById(Bank.class, bankId);
		return bank;
	}
	
	public void add(Bank bank) {
		daoHelper.save(bank);
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}
	
	
}
