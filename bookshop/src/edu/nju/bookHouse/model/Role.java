package edu.nju.bookHouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	public static final Role ROLE_CUSTOMER = new Role(1, "customer");
	public static final Role ROLE_ADMIN = new Role(2, "admin");
	public static final Role ROLE_MANAGER = new Role(3, "manager");
	
	private int id;
	private String type;
	
	public Role(){}
	
	public Role(int id, String type) {
		this.id = id;
		this.type = type;
	}

	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
