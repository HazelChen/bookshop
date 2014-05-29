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
@Table(name="equalCouponsStandard")
public class EqualCouponsStandard {
	private int id;
	private double equalValue;
	
	private ArrayList<EqualCoupons> equalCoupons;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getEqualValue() {
		return equalValue;
	}
	public void setEqualValue(double equalValue) {
		this.equalValue = equalValue;
	}
	
	@OneToMany(mappedBy="equalCoupons",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public ArrayList<EqualCoupons> getEqualCoupons() {
		return equalCoupons;
	}
	public void setEqualCoupons(ArrayList<EqualCoupons> equalCoupons) {
		this.equalCoupons = equalCoupons;
	}
}
