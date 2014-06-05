package edu.nju.bookHouse.dao;

import java.util.List;

import edu.nju.bookHouse.model.Book;

public class BookDao {
	private DaoHelper daoHelper;
	
	public List<Book> getAll() {
		@SuppressWarnings("unchecked")
		List<Book> books = daoHelper.findAll(Book.class);
		return books;
	}
	
	public DaoHelper getDaoHelper() {
		return daoHelper;
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	public void add(Book book) {
		daoHelper.save(book);
	}

	public void update(Book book) {
		daoHelper.update(book);
	}
}
