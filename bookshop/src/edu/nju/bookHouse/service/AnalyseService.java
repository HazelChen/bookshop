package edu.nju.bookHouse.service;

public class AnalyseService {
	private InventoryService inventoryService;
	private UserService userService;
	private BookService bookService;
	private CategoryService categoryService;
	
	public void analyse() {
//		inventoryService.newAnalyse();
		userService.analyse();
		categoryService.analyse();
		bookService.analyse();
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
