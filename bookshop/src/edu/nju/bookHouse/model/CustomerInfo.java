package edu.nju.bookHouse.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customerInfo")
public class CustomerInfo {
	private String id;
	private String gender;
	private String address;
	private Date birthday;
	
	private Date registerDay;
	
	private Bank bank;
	
	private User user;
	
//	private Set<Book> booksBought = new HashSet<Book>();
//	private Set<Book> booksInShoppingCart = new HashSet<Book>();
//	private Set<Book> booksCollected = new HashSet<Book>();
	
	public CustomerInfo(){}
	
	public CustomerInfo(String gender, String address, Date birthDay, Date registerDay, Bank bank) {
		this.gender = gender;
		this.address = address;
		this.birthday = birthDay;
		this.registerDay = registerDay;
		this.bank = bank;
	}

	@Id
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getRegisterDay() {
		return registerDay;
	}

	public void setRegisterDay(Date registerDay) {
		this.registerDay = registerDay;
	}

	@OneToOne(optional = true, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "bank")
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	@OneToOne(mappedBy = "customerInfo")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
//
//	public Set<Book> getBooksBought() {
//		return booksBought;
//	}
//
//	public void setBooksBought(Set<Book> booksBought) {
//		this.booksBought = booksBought;
//	}
//
//	public Set<Book> getBooksInShoppingCart() {
//		return booksInShoppingCart;
//	}
//
//	public void setBooksInShoppingCart(Set<Book> booksInShoppingCart) {
//		this.booksInShoppingCart = booksInShoppingCart;
//	}
//
//	public Set<Book> getBooksCollected() {
//		return booksCollected;
//	}
//
//	public void setBooksCollected(Set<Book> booksCollected) {
//		this.booksCollected = booksCollected;
//	}
//	
	
}
