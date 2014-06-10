package edu.nju.bookHouse.model.analyse;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookanalyse")
public class BookAnalyse {
	private String isbn;
	private String name;
	private double price;
	private int sales;
	private int collections;
	private CategoryAnalyse categoryAnalyse;
	
	public BookAnalyse() {}
	
	public BookAnalyse(String isbn, String name, double price, int collections, CategoryAnalyse categoryAnalyse) {
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.collections = collections;
		this.categoryAnalyse = categoryAnalyse;
	}
	
	@Id
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
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getCollections() {
		return collections;
	}
	public void setCollections(int collections) {
		this.collections = collections;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="category")
	public CategoryAnalyse getCategoryAnalyse() {
		return categoryAnalyse;
	}

	public void setCategoryAnalyse(CategoryAnalyse categoryAnalyse) {
		this.categoryAnalyse = categoryAnalyse;
	}
	
	
	

}
