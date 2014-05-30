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
@Table(name="discountCoupons")
public class DiscountCoupons {
	private int id;
	private DiscountCouponsStandard standard;
	private CustomerInfo customerInfo;
	private OrderForm orderForm;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="standard")
	public DiscountCouponsStandard getStandard() {
		return standard;
	}
	public void setStandard(DiscountCouponsStandard standard) {
		this.standard = standard;
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
	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}
	
}
