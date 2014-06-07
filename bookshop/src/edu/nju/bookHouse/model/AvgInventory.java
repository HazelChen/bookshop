package edu.nju.bookHouse.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="avginventory")
public class AvgInventory {
	private int id;
	private double inventory;
	private int itemCount;
	private Set<BookInventory> bookInventories;
	
	public AvgInventory(){}
	
	public AvgInventory(int itemCount) {
		this.itemCount = itemCount;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getInventory() {
		return inventory;
	}

	public void setInventory(double inventory) {
		this.inventory = inventory;
	}

	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	@OneToMany(mappedBy="avgInventory",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<BookInventory> getBookInventories() {
		return bookInventories;
	}
	public void setBookInventories(Set<BookInventory> bookInventories) {
		this.bookInventories = bookInventories;
	}
	
	
	
}
