package edu.nju.bookHouse.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.bookHouse.dao.BookInCartDao;
import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.BookInCart;
import edu.nju.bookHouse.model.CustomerInfo;

public class BookInCartService {
	private BookInCartDao bookInCartDao;
	
	public void add(String bookIdString, int customerInfoId) {
		int bookId = Integer.parseInt(bookIdString);
		Book book = new Book(bookId);
		CustomerInfo customerInfo = new CustomerInfo(customerInfoId);
		BookInCart bookInCart = bookInCartDao.getBookInCart(book, customerInfo);
		
		if (bookInCart == null) {
			Calendar calendar = Calendar.getInstance();
			Date date = calendar.getTime();
			bookInCart = new BookInCart(customerInfo, book, date);
			bookInCartDao.add(bookInCart);
		} else {
			int count = bookInCart.getCount() + 1;
			bookInCart.setCount(count);
			bookInCartDao.update(bookInCart);
		}
		
	}

	public void setBookInCartDao(BookInCartDao bookInCartDao) {
		this.bookInCartDao = bookInCartDao;
	}

	public ArrayList<BookInCart> getBookInCarts(int customerInfoid,
			ArrayList<Book> cartBooks) {
		ArrayList<BookInCart> bookInCarts = new ArrayList<BookInCart>();
		
		for (Book book : cartBooks) {
			BookInCart bookInCart = bookInCartDao.getBookInCart(book, new CustomerInfo(customerInfoid));
			bookInCarts.add(bookInCart);
		}
		return bookInCarts;
	}

	public double totalPrice(ArrayList<BookInCart> bookInCarts) {
		double totalPrice = 0;
		for (BookInCart bookInCart : bookInCarts) {
			Book book = bookInCart.getBook();
			totalPrice += book.getPrice() * bookInCart.getCount();
		}
		return totalPrice;
	}
}
