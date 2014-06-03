package edu.nju.bookHouse.service;

import java.util.Date;
import java.util.List;

import edu.nju.bookHouse.dao.BookDao;
import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.Category;

public class BookService {
	private DateChanger dateChanger;
	private BookDao bookDao;
	
	public List<Book> getAll() {
		return bookDao.getAll();
	}

	public void addBook(String name, String iSBN, String author, String press,
			String publishDateString, String priceString, String categoryString, String countString,
			String description) {
		Date publishDate = dateChanger.StringToDate(publishDateString);
		double price = Double.parseDouble(priceString);
		Category category = new Category(categoryString);
		int count = Integer.parseInt(countString);
		
		Book book = new Book(name, iSBN, author, press, publishDate, price, description, count, category);
			
		bookDao.add(book);
	}
	
	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void setDateChanger(DateChanger dateChanger) {
		this.dateChanger = dateChanger;
	}
}
