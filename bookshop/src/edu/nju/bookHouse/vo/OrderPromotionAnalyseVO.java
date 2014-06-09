package edu.nju.bookHouse.vo;

public class OrderPromotionAnalyseVO {
	public int preSales;
	public int currentSales;
	public double growthRate;
	
	public OrderPromotionAnalyseVO(int pre, int current, double rate) {
		this.preSales = pre;
		this.currentSales = current;
		this.growthRate = rate;
	}
}
