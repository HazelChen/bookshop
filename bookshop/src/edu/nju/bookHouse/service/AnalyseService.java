package edu.nju.bookHouse.service;

public class AnalyseService {
	private InventoryService inventoryService;
	private UserService userService;
	
	public void analyse() {
//		inventoryService.newAnalyse();
		userService.analyse();
		
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
