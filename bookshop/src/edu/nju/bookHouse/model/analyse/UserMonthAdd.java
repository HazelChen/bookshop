package edu.nju.bookHouse.model.analyse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userMonthAdd")
public class UserMonthAdd {
	private String month;
	private int count;
	
	public UserMonthAdd(){}
	
	public UserMonthAdd(String month, int count) {
		this.month = month;
		this.count = count;
	}
	
	@Id
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
