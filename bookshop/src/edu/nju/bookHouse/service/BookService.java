package edu.nju.bookHouse.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import edu.nju.bookHouse.dao.BookDao;
import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.BookAnalyse;
import edu.nju.bookHouse.model.BookInCart;
import edu.nju.bookHouse.model.BuyBook;
import edu.nju.bookHouse.model.Category;
import edu.nju.bookHouse.model.CategoryAnalyse;

public class BookService {
	private CategoryService categoryService;
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

	public void reduceInventory(List<BookInCart> bookInCarts) {
		for (BookInCart bookInCart : bookInCarts) {
			Book book = bookInCart.getBook();
			int newCount = book.getCount() - bookInCart.getCount();
			book.setCount(newCount);
			bookDao.update(book);
		}
	}
	
	public void analyse() {
		bookDao.removeAllAnalyse();
		
		List<Book> books = bookDao.getAll();
		for (Book book : books) {
			CategoryAnalyse categoryAnalyse = categoryService.findCategoryAnalyse(book.getCategory());
			BookAnalyse bookAnalyse = new BookAnalyse(book.getISBN(), 
					book.getName(), book.getPrice(), book.getCustomersCollectedIt().size(), categoryAnalyse);
			int sales = 0;
			Iterator<BuyBook> iterator = book.getBuyBooks().iterator();
			while (iterator.hasNext()) {
				BuyBook buyBook = iterator.next();
				sales += buyBook.getCount();
			}
			bookAnalyse.setSales(sales);
			bookDao.add(bookAnalyse);
		}
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public List<List<BookAnalyse>> findBestBookAnalyse(
			List<CategoryAnalyse> category) {
		List<List<BookAnalyse>> list = new ArrayList<List<BookAnalyse>>();
		for (CategoryAnalyse categoryAnalyse : category) {
			Set<BookAnalyse> bookAnalyses = categoryAnalyse.getBookAnalyses();
			List<BookAnalyse> best = findBestFive(bookAnalyses);
			list.add(best);
		}
		return list;
	}
	
	private List<BookAnalyse> findBestFive(Set<BookAnalyse> bookAnalyses) {
		ArrayList<BookAnalyse> original = new ArrayList<BookAnalyse>(bookAnalyses);
		//倒序排序
		java.util.Collections.sort(original, new Comparator<BookAnalyse>() {

			@Override
			public int compare(BookAnalyse b1, BookAnalyse b2) {
				return b2.getSales() - b1.getSales();
			}
		});
		
		ArrayList<BookAnalyse> result = new ArrayList<BookAnalyse>();
		for(int i = 0; i < 5; i++) {
			if (i < original.size()) {
				BookAnalyse bookAnalyse = original.get(i);
				result.add(bookAnalyse);
			}
		}
		return result;
	}

	public List<BookAnalyse> findAllBookAnalyses() {
		return bookDao.findAllBookAnalyses();
	}
	
	
}
