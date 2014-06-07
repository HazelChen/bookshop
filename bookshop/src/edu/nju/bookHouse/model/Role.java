package edu.nju.bookHouse.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	private int id;
	private String type;
	private Set<User> users;
	
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

	
	
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
