package edu.nju.bookHouse.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="discountCouponsStandard")
public class DiscountCouponsStandard {
	private int id;
	private double discount;//0.8
	
	private ArrayList<DiscountCoupons> discountCoupons;
	
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
	
	@OneToMany(mappedBy="discountcoupons",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public ArrayList<DiscountCoupons> getDiscountCoupons() {
		return discountCoupons;
	}
	public void setDiscountCoupons(ArrayList<DiscountCoupons> discountCoupons) {
		this.discountCoupons = discountCoupons;
	}
}
