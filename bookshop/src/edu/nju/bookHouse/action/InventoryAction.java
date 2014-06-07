package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.AvgInventory;
import edu.nju.bookHouse.model.BookInventory;
import edu.nju.bookHouse.service.InventoryService;

public class InventoryAction extends BaseAction{
	private static final long serialVersionUID = 9101588051661240477L;
	
	private double averageInventory;
	private double itemCount;
	private List<BookInventory> bookInventories;
	
	private InventoryService inventoryService;
	
	@Override
	public String execute() {
		AvgInventory avgInventory = inventoryService.getNewestAvgInventory();
		averageInventory = avgInventory.getInventory();
		itemCount = avgInventory.getItemCount();
		
		bookInventories = inventoryService.getBookInventories(avgInventory);
		return SUCCESS;
	}

	public double getAverageInventory() {
		return averageInventory;
	}

	public double getItemCount() {
		return itemCount;
	}

	public List<BookInventory> getBookInventories() {
		return bookInventories;
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
}
