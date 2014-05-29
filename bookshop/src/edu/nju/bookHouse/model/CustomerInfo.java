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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customerInfo")
public class CustomerInfo {
	private int id;
	private String gender;
	private String address;
	private Date birthday;
	
	private Date registerDay;
	
	private Bank bank;
	
	private User user;
	
	private Set<Book> booksInShoppingCart = new HashSet<Book>();
	private Set<Book> booksCollected = new HashSet<Book>();
	private Set<Order> orders = new HashSet<Order>();
	private Set<DiscountCoupons> discountCoupons = new HashSet<DiscountCoupons>();
	private Set<EqualCoupons> equalCoupons = new HashSet<EqualCoupons>();
	
	
	public CustomerInfo(){}
	
	public CustomerInfo(String gender, String address, Date birthDay, Date registerDay, Bank bank) {
		this.gender = gender;
		this.address = address;
		this.birthday = birthDay;
		this.registerDay = registerDay;
		this.bank = bank;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
	
	@ManyToMany(mappedBy="customersPutCart", fetch=FetchType.EAGER)
	public Set<Book> getBooksInShoppingCart() {
		return booksInShoppingCart;
	}

	public void setBooksInShoppingCart(Set<Book> booksInShoppingCart) {
		this.booksInShoppingCart = booksInShoppingCart;
	}

	@ManyToMany(mappedBy="customersCollectedIt", fetch=FetchType.EAGER)
	public Set<Book> getBooksCollected() {
		return booksCollected;
	}

	public void setBooksCollected(Set<Book> booksCollected) {
		this.booksCollected = booksCollected;
	}

	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	@OneToMany(mappedBy="discountCoupons",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<DiscountCoupons> getDiscountCoupons() {
		return discountCoupons;
	}

	public void setDiscountCoupons(Set<DiscountCoupons> discountCoupons) {
		this.discountCoupons = discountCoupons;
	}

	@OneToMany(mappedBy="equalCoupons",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<EqualCoupons> getEqualCoupons() {
		return equalCoupons;
	}

	public void setEqualCoupons(Set<EqualCoupons> equalCoupons) {
		this.equalCoupons = equalCoupons;
	}
}
