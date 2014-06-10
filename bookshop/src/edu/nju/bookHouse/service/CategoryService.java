package edu.nju.bookHouse.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import edu.nju.bookHouse.dao.CategoryDao;
import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.BuyBook;
import edu.nju.bookHouse.model.Category;
import edu.nju.bookHouse.model.analyse.CategoryAnalyse;

public class CategoryService {
	private CategoryDao categoryDao;
	
	private OrderService orderService;
	
	public List<Category> getAll() {
		return categoryDao.getAllCategories();
	}
	
	public Category find(String category) {
		return categoryDao.find(category);
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	
	public void analyse() {
		categoryDao.removeAllAnalyse();
		
		List<Category> categories = categoryDao.getAllCategories();
		for (Category category : categories) {
			Iterator<Book> bookIterator = category.getBooks().iterator();
			int totalCount = 0;
			while (bookIterator.hasNext()) {
				Book books = bookIterator.next();
				Iterator<BuyBook> buyBookIterator = books.getBuyBooks().iterator();
				while (buyBookIterator.hasNext()) {
					BuyBook buyBook = buyBookIterator.next();
					totalCount += buyBook.getCount();
				}
			}
			CategoryAnalyse categoryAnalyse = new CategoryAnalyse(category.getCategory(), totalCount);
			categoryDao.add(categoryAnalyse);
		}
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public CategoryAnalyse findCategoryAnalyse(Category category) {
		String categoryString = category.getCategory();
		return categoryDao.findCategoryAnalyse(categoryString);
	}

	public List<CategoryAnalyse> findAllCategoryAnalyses() {
		return categoryDao.findAllCategoryAnalyse();
	}
	
	
}
