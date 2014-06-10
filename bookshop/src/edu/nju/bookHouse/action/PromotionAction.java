package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.analyse.DiscountCouponsAnalyse;
import edu.nju.bookHouse.model.analyse.EqualCouponsAnalyse;
import edu.nju.bookHouse.service.CouponsService;
import edu.nju.bookHouse.service.OrderService;
import edu.nju.bookHouse.vo.OrderPromotionAnalyseVO;

public class PromotionAction extends BaseAction{
	private static final long serialVersionUID = 7305639516823631396L;
	
	private int preSales;
	private int currentSales;
	private double growthRate;
	private List<EqualCouponsAnalyse> equalCoupons;
	private List<DiscountCouponsAnalyse> discountCoupons;
	private double equalUsed;
	private double equalNotUsed;
	private double discountUsed;
	private double discountNotlUsed;
	
	private OrderService orderService;
	private CouponsService couponsService;
	
	@Override
	public String execute() {
		OrderPromotionAnalyseVO vo = orderService.getPromotionSales();
		this.preSales = vo.preSales;
		this.currentSales = vo.currentSales;
		this.growthRate = vo.growthRate;
		equalCoupons = couponsService.getEqualAnalyse();
		discountCoupons = couponsService.getDiscountAnalyse();
		
		EqualCouponsAnalyse totalEqual = equalCoupons.get(equalCoupons.size() - 1);
		equalUsed = totalEqual.getUsedPercent();
		equalNotUsed = 100 - equalUsed;
		
		DiscountCouponsAnalyse totalDiscount = discountCoupons.get(discountCoupons.size() - 1);
		discountUsed = totalDiscount.getUsedPercent();
		discountNotlUsed = 100 - discountUsed;
		return SUCCESS;
	}

	public int getPreSales() {
		return preSales;
	}

	public int getCurrentSales() {
		return currentSales;
	}

	public double getGrowthRate() {
		return growthRate;
	}

	public List<EqualCouponsAnalyse> getEqualCoupons() {
		return equalCoupons;
	}

	public List<DiscountCouponsAnalyse> getDiscountCoupons() {
		return discountCoupons;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setCouponsService(CouponsService couponsService) {
		this.couponsService = couponsService;
	}

	public double getEqualUsed() {
		return equalUsed;
	}

	public double getEqualNotUsed() {
		return equalNotUsed;
	}

	public double getDiscountUsed() {
		return discountUsed;
	}

	public double getDiscountNotlUsed() {
		return discountNotlUsed;
	}

}
