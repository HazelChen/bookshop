package edu.nju.bookHouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {
	private String id;
	private double balance;
	private User user;
	
	public Bank(){};
	
	public Bank(String id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@OneToOne(mappedBy = "bank")
	public User getCustomer() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
