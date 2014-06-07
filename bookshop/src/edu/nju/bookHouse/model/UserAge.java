package edu.nju.bookHouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userage")
public class UserAge {
	private String ageRange;
	private int count;
	private double percentage;
	
	public UserAge() {
	}
	
	
	public UserAge(String ageRange, int count) {
		this.ageRange = ageRange;
		this.count = count;
	}
	
	
	@Id
	public String getAgeRange() {
		return ageRange;
	}
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
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
