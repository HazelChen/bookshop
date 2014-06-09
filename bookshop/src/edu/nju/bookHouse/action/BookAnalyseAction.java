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
	private List<BookAnalyse> bookAnalyses;
	private String categoryAnalyseData;
	private String bookAnalyseData;
	
	private BookService bookService;
	private CategoryService categoryService;
	
	@Override
	public String execute() {
		category = categoryService.findAllCategoryAnalyses();
		responseBook = bookService.findBestBookAnalyse(category);
		bookAnalyses = bookService.findAllBookAnalyses();
		generateCategoryData();
		generateBookData();
		return SUCCESS;
	}
	
	private void generateBookData() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (BookAnalyse bookAnalyse : bookAnalyses) {
			sb.append("[");
			sb.append(bookAnalyse.getPrice() + ",");
			sb.append(bookAnalyse.getSales() + ",");
			sb.append(bookAnalyse.getCollections());
			sb.append("],");
		}
		sb.append("]");
		bookAnalyseData = sb.toString();
		System.out.println(bookAnalyseData);
	}

	private void generateCategoryData() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < category.size(); i++) {
			CategoryAnalyse categoryAnalyse = category.get(i);
			sb.append("{y:" + categoryAnalyse.getCount() + ",");
			sb.append("color:colors[" + i + "],");
			sb.append("drilldown:{");
			sb.append("name:'" + categoryAnalyse.getCategory() + "',");
			sb.append("categories:[");
			List<BookAnalyse> bookAnalyses = responseBook.get(i);
			for (int j = 0; j < bookAnalyses.size(); j++) {
				sb.append("'" + bookAnalyses.get(j).getIsbn() + "',");
			}
			sb.append("],");
			sb.append("data:[");
			for (int j = 0; j < bookAnalyses.size(); j++) {
				sb.append(bookAnalyses.get(j).getSales() + ",");
			}
			sb.append("],");
			sb.append("color:colors[" + i + "]}");
			sb.append("},");
		}
		sb.append("]");
		categoryAnalyseData = sb.toString();
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

	public String getCategoryAnalyseData() {
		return categoryAnalyseData;
	}

	public List<BookAnalyse> getBookAnalyses() {
		return bookAnalyses;
	}

	public String getBookAnalyseData() {
		return bookAnalyseData;
	}
}
