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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="orderForm")
public class OrderForm {
	private int id;
	private State state;
	
	private Date confirmDate;
	private Date distributeDate;
	private Date sendDate;
	private Date receiveDate;
	
	private double price;
	
	private CustomerInfo customerInfo;
	
	private Set<BuyBook> buyBooks = new HashSet<BuyBook>();
	private Set<DiscountCoupons> discountCoupons = new HashSet<DiscountCoupons>();
	private Set<EqualCoupons> equalCoupons = new HashSet<EqualCoupons>();
	
	public OrderForm(){}
	
	public OrderForm(Date confirmDate, CustomerInfo customerInfo, double price) {
		this.state = State.CONFIRM;
		this.confirmDate = confirmDate;
		this.customerInfo = customerInfo;
		this.price = price;
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
	@JoinColumn(name="state")
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	public Date getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}
	
	public Date getDistributeDate() {
		return distributeDate;
	}
	public void setDistributeDate(Date distributeDate) {
		this.distributeDate = distributeDate;
	}
	
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	public Date getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="customerInfoId")
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	
	@OneToMany(mappedBy="orderForm",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<BuyBook> getBuyBooks() {
		return buyBooks;
	}
	public void setBuyBooks(Set<BuyBook> books) {
		this.buyBooks = books;
	}
	
	@OneToMany(mappedBy="orderForm",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<DiscountCoupons> getDiscountCoupons() {
		return discountCoupons;
	}
	public void setDiscountCoupons(Set<DiscountCoupons> discountCoupons) {
		this.discountCoupons = discountCoupons;
	}
	
	@OneToMany(mappedBy="orderForm",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<EqualCoupons> getEqualCoupons() {
		return equalCoupons;
	}
	public void setEqualCoupons(Set<EqualCoupons> equalCoupons) {
		this.equalCoupons = equalCoupons;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
