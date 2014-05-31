package edu.nju.bookHouse.service;

import java.util.List;

import edu.nju.bookHouse.dao.BookDao;
import edu.nju.bookHouse.model.Book;

public class BookService {
	private BookDao bookDao;
	
	public List<Book> getAll() {
		return bookDao.getAll();
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	
}
