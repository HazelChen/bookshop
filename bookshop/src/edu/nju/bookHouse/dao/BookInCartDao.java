package edu.nju.bookHouse.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.BookInCart;
import edu.nju.bookHouse.model.CustomerInfo;

public class BookInCartDao{
	private DaoHelper daoHelper;
	
	public void add(BookInCart bookInCart) {
		daoHelper.save(bookInCart);
	}
	
	public BookInCart getBookInCart(Book book, CustomerInfo customerInfo) {
		ArrayList<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("book", book));
		expressions.add(Restrictions.eq("customerInfo", customerInfo));
		
		@SuppressWarnings("unchecked")
		List<BookInCart> bookInCarts = daoHelper.find(BookInCart.class, expressions);
		if (bookInCarts.size() == 0) {
			return null;
		} else {
			return bookInCarts.get(0);
		}
	}
	
	public void update(BookInCart bookInCart) {
		daoHelper.update(bookInCart);
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}
}
