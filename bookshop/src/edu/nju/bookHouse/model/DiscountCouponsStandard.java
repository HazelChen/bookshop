package edu.nju.bookHouse.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="discountCouponsStandard")
public class DiscountCouponsStandard {
	private int id;
	private double discount;//0.8
	
	private Set <DiscountCoupons> discountCoupons = new HashSet<DiscountCoupons>();
	
	public DiscountCouponsStandard(){}
	
	public DiscountCouponsStandard(double discount) {
		this.discount = discount;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	@OneToMany(mappedBy="standard",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<DiscountCoupons> getDiscountCoupons() {
		return discountCoupons;
	}
	public void setDiscountCoupons(Set<DiscountCoupons> discountCoupons) {
		this.discountCoupons = discountCoupons;
	}
	
	
	
	
	
}
