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
import javax.print.attribute.HashAttributeSet;
@Entity
@Table(name="state")
public class State {
	public static final State CONFIRM = new State(1, "confirm");
	public static final State DISTRIBUTE = new State(2, "distribute");
	public static final State SEND = new State(3, "send");
	public static final State RECEIVED = new State(4, "received");
	
	private int id;
	private String state;
	
	private Set<Order> orders = new HashSet<Order>();
	
	public State(){}
	
	public State(int id, String state) {
		this.id = id;
		this.state = state;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@OneToMany(mappedBy="state",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
}
