package edu.nju.bookHouse.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookinventory")
public class BookInventory {
	private int id;
	private String isbn;
	private String name;
	private double price;
	private double fundsUsedAvg;
	private int item;
	private double itemPercentage;
	private double fundsUsedAvgCount;
	private double fundsUsedAvgCountPer;
	
	private String category;
	private AvgInventory avgInventory;
	
	public BookInventory() {}
	
	public BookInventory(String ISBN, String name, double price, AvgInventory avgInventory) {
		this.isbn = ISBN;
		this.name = name;
		this.price = price;
		this.avgInventory = avgInventory;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getFundsUsedAvg() {
		return fundsUsedAvg;
	}
	public void setFundsUsedAvg(double fundsUsedAvg) {
		this.fundsUsedAvg = fundsUsedAvg;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public double getItemPercentage() {
		return itemPercentage;
	}
	public void setItemPercentage(double itemPercentage) {
		this.itemPercentage = itemPercentage;
	}
	public double getFundsUsedAvgCount() {
		return fundsUsedAvgCount;
	}
	public void setFundsUsedAvgCount(double fundsUsedAvgCount) {
		this.fundsUsedAvgCount = fundsUsedAvgCount;
	}
	public double getFundsUsedAvgCountPer() {
		return fundsUsedAvgCountPer;
	}
	public void setFundsUsedAvgCountPer(double fundsUsedAvgCountPer) {
		this.fundsUsedAvgCountPer = fundsUsedAvgCountPer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="avgInventoryId")
	public AvgInventory getAvgInventory() {
		return avgInventory;
	}
	public void setAvgInventory(AvgInventory avgInventory) {
		this.avgInventory = avgInventory;
	}
	
	
}
