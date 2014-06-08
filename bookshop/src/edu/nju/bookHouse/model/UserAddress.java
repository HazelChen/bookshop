package edu.nju.bookHouse.model;

import javax.persistence.Id;
import javax.persistence.Table;


import javax.persistence.Entity;

@Entity
@Table(name="userAddress")
public class UserAddress {
	private String address;
	private int count;
	private double percentage;
	
	public UserAddress(){}
	
	public UserAddress(String address, int count) {
		this.address = address;
		this.count = count;
	}
	
	@Id
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof UserAddress)) {
			return false;
		} else {
			UserAddress other = (UserAddress)object;
			return this.address.equals(other.address);
		}
	}
	
	@Override
	public int hashCode() {
		return address.hashCode() + 1;
	}
	
	
}
