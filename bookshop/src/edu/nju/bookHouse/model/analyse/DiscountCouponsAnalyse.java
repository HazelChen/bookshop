package edu.nju.bookHouse.model.analyse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="discountcouponsanalyse")
public class DiscountCouponsAnalyse {
	private String value;
	private int totalCount;
	private int usedCount;
	private double usedPercent;
	
	public DiscountCouponsAnalyse(){}
	
	public DiscountCouponsAnalyse(String value, int totalCount, int usedCount, double usedPercent) {
		this.value = value;
		this.totalCount = totalCount;
		this.usedCount = usedCount;
		this.usedPercent = usedPercent;
	}
	
	
	@Id
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getUsedCount() {
		return usedCount;
	}
	public void setUsedCount(int usedCount) {
		this.usedCount = usedCount;
	}
	public double getUsedPercent() {
		return usedPercent;
	}
	public void setUsedPercent(double usedPercent) {
		this.usedPercent = usedPercent;
	}
	
	
}
