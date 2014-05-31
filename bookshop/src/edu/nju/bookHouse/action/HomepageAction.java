package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.Category;
import edu.nju.bookHouse.service.BookService;
import edu.nju.bookHouse.service.CategoryService;

public class HomepageAction extends BaseAction{
	private static final long serialVersionUID = 1978030674588040286L;
	
	private List<Category> categories;
	private List<Book> books;
	
	private CategoryService categoryService;
	private BookService bookService;
	
	@Override
	public String execute() {
		categories = categoryService.getAll();
		books = bookService.getAll();
		return SUCCESS;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	
}
