package edu.nju.bookHouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	private int id;
	private String type;
	private User user;
	
	public Role(){}
	
	public Role(int id, String type) {
		this.id = id;
		this.type = type;
	}
	
	public boolean customer() {
		return this.id == 1;
	}
	
	public boolean admin() {
		return this.id == 2;
	}
	
	public boolean manager() {
		return this.id == 3;
	}

	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@OneToOne(mappedBy = "role")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
