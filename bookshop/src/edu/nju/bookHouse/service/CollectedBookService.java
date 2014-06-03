package edu.nju.bookHouse.service;

import java.util.Calendar;
import java.util.Date;

import edu.nju.bookHouse.dao.CollectedBookDao;
import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.BookCollected;
import edu.nju.bookHouse.model.CustomerInfo;

public class CollectedBookService {
	private CollectedBookDao collectedBookDao;
	
	public void addCollectedBook(String bookIdString, int customerInfoId) {
		int bookId = Integer.parseInt(bookIdString);
		Book book = new Book(bookId);
		
		CustomerInfo customerInfo = new CustomerInfo(customerInfoId);
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		
		BookCollected bookCollected = new BookCollected(customerInfo, book, date);
		
		collectedBookDao.add(bookCollected);
	}

	public void setCollectedBookDao(CollectedBookDao collectedBookDao) {
		this.collectedBookDao = collectedBookDao;
	}
}
