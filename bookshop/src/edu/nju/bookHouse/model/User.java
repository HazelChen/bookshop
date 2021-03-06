package edu.nju.bookHouse.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	private String username;
	private String password;
	private Role role;
	private CustomerInfo customerInfo;
	
	public User(){}
	
	public User(String username, String password, Role role, CustomerInfo customerInfo) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.customerInfo = customerInfo;
	}
	
	public boolean admin(){
		return role.admin();
	}
	
	public boolean customer() {
		return role.customer();
	}
	
	public boolean manager() {
		return role.manager();
	}
	
	@Id
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="role")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@OneToOne(optional = true, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "customerInfo")
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	
	
}
