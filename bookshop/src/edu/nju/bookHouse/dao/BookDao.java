package edu.nju.bookHouse.dao;

import java.util.List;

import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.analyse.BookAnalyse;

public class BookDao {
	private DaoHelper daoHelper;
	private StaticsDaoHelper sDaoHelper;
	
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
	
	public void setsDaoHelper(StaticsDaoHelper sDaoHelper) {
		this.sDaoHelper = sDaoHelper;
	}

	public void add(BookAnalyse bookAnalyse) {
		sDaoHelper.save(bookAnalyse);
	}

	public void removeAllAnalyse() {
		@SuppressWarnings("unchecked")
		List<BookAnalyse> bookAnalyses = sDaoHelper.findAll(BookAnalyse.class);
		sDaoHelper.removeAll(bookAnalyses);
	}

	@SuppressWarnings("unchecked")
	public List<BookAnalyse> findAllBookAnalyses() {
		return sDaoHelper.findAll(BookAnalyse.class);
	}
}
