package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.Category;
import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.BookService;
import edu.nju.bookHouse.service.CategoryService;

public class AddBookAction extends BaseAction{
	private static final long serialVersionUID = 9073943820453928554L;

	private List<Category> categories;
	
	private CategoryService categoryService;
	private BookService bookService;
	
	public String show() {
		this.categories = categoryService.getAll();
		return SUCCESS;
	}
	
	public String add() {
		String name = request.getParameter("name");
		String ISBN = request.getParameter("ISBN");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String publishDate = request.getParameter("publishDate"); 
		String price = request.getParameter("price"); 
		String category = request.getParameter("category"); 
		String count = request.getParameter("count"); 
		String description = request.getParameter("description"); 
		
		bookService.addBook(name, ISBN, author, press, publishDate, price, category, count, description);
		return SUCCESS;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	
}
