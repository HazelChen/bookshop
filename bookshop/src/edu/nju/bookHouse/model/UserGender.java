package edu.nju.bookHouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userGender")
public class UserGender {
	private String gender;
	private int count;
	private double percentage;
	
	public UserGender(){}
	
	public UserGender(String gender, int count, double percentage) {
		this.gender = gender;
		this.count = count;
		this.percentage = percentage;
	}
	
	@Id
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	
	
}
