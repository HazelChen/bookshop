package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.BookAnalyse;
import edu.nju.bookHouse.model.CategoryAnalyse;
import edu.nju.bookHouse.service.BookService;
import edu.nju.bookHouse.service.CategoryService;

public class BookAnalyseAction extends BaseAction{
	private static final long serialVersionUID = 7954099215769040966L;
	
	private List<CategoryAnalyse> category;
	private List<List<BookAnalyse>> responseBook;
	
	private BookService bookService;
	private CategoryService categoryService;
	
	@Override
	public String execute() {
		category = categoryService.findAllCategoryAnalyses();
		responseBook = bookService.findBestBookAnalyse(category);
		return SUCCESS;
	}

	public List<CategoryAnalyse> getCategory() {
		return category;
	}

	public List<List<BookAnalyse>> getResponseBook() {
		return responseBook;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
