package edu.nju.bookHouse.service;

import edu.nju.bookHouse.dao.BankDao;
import edu.nju.bookHouse.model.Bank;

public class BankService {
	private BankDao bankDao;
	
	public Bank find(String bankId) {
		Bank bank = bankDao.find(bankId);
		
		if (bank == null) {
			bank = new Bank(bankId, 1000);
			bankDao.add(bank);
		}
		
		return bank;
	}

	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}
	
	
}
