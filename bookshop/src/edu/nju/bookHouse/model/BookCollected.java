package edu.nju.bookHouse.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="bookcollected")
public class BookCollected {
	private int id;
	private CustomerInfo customerInfo;
	private Book book;
	private Date date;
	
	public BookCollected(){}
	
	public BookCollected(CustomerInfo customerInfo, Book book, Date date) {
		this.customerInfo = customerInfo;
		this.book = book;
		this.date = date;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
	@JoinColumn(name="customerInfoId")
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customer) {
		this.customerInfo = customer;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
	@JoinColumn(name="bookId")
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
