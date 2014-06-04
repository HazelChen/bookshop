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
@Table(name="equalCoupons")
public class EqualCoupons {
	private int id;
	private EqualCouponsStandard standard;
	private CustomerInfo customerInfo;
	private OrderForm orderForm;
	
	public EqualCoupons(){}
	
	public EqualCoupons(EqualCouponsStandard standard, CustomerInfo customerInfo) {
		this.standard = standard;
		this.customerInfo = customerInfo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setStandard(EqualCouponsStandard standard) {
		this.standard = standard;
	}
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="standard")
	public EqualCouponsStandard getStandard() {
		return standard;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="customerInfoId")
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="orderFormId")
	public OrderForm getOrderForm() {
		return orderForm;
	}
	public void setOrderForm(OrderForm order) {
		this.orderForm = order;
	}
}
