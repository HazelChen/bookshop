package edu.nju.bookHouse.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="book")
public class Book {
	private int id;
	private String name;
	private String ISBN;
	private String author;
	private String press;
	private Date publishDate;
	private double price;
	private String description;
	private int count;
	
	private Category category;
	
	private Set<BuyBook> buyBooks = new HashSet<BuyBook>();
	private Set<CustomerInfo> customersPutCart = new HashSet<CustomerInfo>();
	private Set<CustomerInfo> customersCollectedIt = new HashSet<CustomerInfo>();
	
	public Book(){}
	
	public Book(int bookId) {
		this.id = bookId;
	}
	
	public Book(String name, String ISBN, String author, String press, Date publishDate, double price, String description, int count, Category category) {
		this.name = name;
		this.ISBN = ISBN;
		this.author = author;
		this.press = press;
		this.publishDate = publishDate;
		this.price = price;
		this.description = description;
		this.count = count;
		this.category = category;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="category")
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(
			name="bookincart",
			joinColumns=@JoinColumn(name="bookId", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="customerInfoId", referencedColumnName="id")
			)
	public Set<CustomerInfo> getCustomersPutCart() {
		return customersPutCart;
	}
	public void setCustomersPutCart(Set<CustomerInfo> customersPutCart) {
		this.customersPutCart = customersPutCart;
	}
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(
			name="bookcollected",
			joinColumns=@JoinColumn(name="bookId", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="customerInfoId", referencedColumnName="id")
			)
	public Set<CustomerInfo> getCustomersCollectedIt() {
		return customersCollectedIt;
	}
	public void setCustomersCollectedIt(Set<CustomerInfo> customersCollectedIt) {
		this.customersCollectedIt = customersCollectedIt;
	}
	
	
	@OneToMany(mappedBy="book",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<BuyBook> getBuyBooks() {
		return buyBooks;
	}
	public void setBuyBooks(Set<BuyBook> buyBooks) {
		this.buyBooks = buyBooks;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
