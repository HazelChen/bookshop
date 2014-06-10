package edu.nju.bookHouse.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.nju.bookHouse.dao.InventoryDao;
import edu.nju.bookHouse.model.Book;
import edu.nju.bookHouse.model.analyse.AvgInventory;
import edu.nju.bookHouse.model.analyse.BookInventory;

public class InventoryService {
	private BookService bookService;
	private InventoryDao inventoryDao;
	
	public void newAnalyse() {
		List<Book> books = bookService.getAll();
		AvgInventory avgInventory = new AvgInventory(books.size());
		List<BookInventory> bookInventories = new ArrayList<BookInventory>();
		int totalInventory = 0;
		
		for (Book book : books) {
			BookInventory bookInventory = new BookInventory(book.getISBN(), 
					book.getName(), book.getPrice(), avgInventory);
			bookInventories.add(bookInventory);
			totalInventory += book.getCount();
		}
		
		double avgInventoryCount = ((int)(totalInventory / books.size() * 100)) / 100;
		avgInventory.setInventory(avgInventoryCount);
		
		detailAnalyse(bookInventories, avgInventory);
		category(bookInventories);
		
		inventoryDao.add(avgInventory, bookInventories);
	}
	
	private void detailAnalyse(List<BookInventory> bookInventories, AvgInventory avgInventory) {
		double totalAvgFunds = 0;
		for (BookInventory bookInventory : bookInventories) {
			double avgFunds = bookInventory.getPrice() * avgInventory.getInventory();
			bookInventory.setFundsUsedAvg(avgFunds);
			totalAvgFunds += avgFunds;
		}
		
		Collections.sort(bookInventories, new Comparator<BookInventory>() {
			@Override
			public int compare(BookInventory bookInventory1, BookInventory bookInventory2) {
				if (bookInventory1.getFundsUsedAvg() > bookInventory2.getFundsUsedAvg()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		double avgFundsCount = 0;
		for (int i = 1;i < bookInventories.size() + 1; i++) {
			BookInventory bookInventory = bookInventories.get(i - 1);
			bookInventory.setItem(i);
			bookInventory.setItemPercentage(((int)((i + 0.0) / bookInventories.size() * 1000)) / 10);
			avgFundsCount += bookInventory.getFundsUsedAvg();
			bookInventory.setFundsUsedAvgCount(avgFundsCount);
			bookInventory.setFundsUsedAvgCountPer(((int)(avgFundsCount / totalAvgFunds * 1000)) / 10);
		}
	}
	
	private void category(List<BookInventory> bookInventories) {
		for (BookInventory bookInventory : bookInventories) {
			double itemPer = bookInventory.getItemPercentage();
			if (itemPer <= 15) {
				bookInventory.setCategory("A");
			} else if (itemPer <= 30) {
				bookInventory.setCategory("B");
			} else {
				bookInventory.setCategory("C");
			}
		}
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	public AvgInventory getNewestAvgInventory() {
		return inventoryDao.getIdMax();
	}

	public List<BookInventory> getBookInventories(AvgInventory avgInventory) {
		return inventoryDao.getBookInventories(avgInventory);
	}
}
