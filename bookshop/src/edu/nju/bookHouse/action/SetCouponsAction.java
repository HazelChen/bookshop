package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.DiscountCouponsStandard;
import edu.nju.bookHouse.model.EqualCouponsStandard;
import edu.nju.bookHouse.service.CouponsService;

public class SetCouponsAction extends BaseAction{
	private static final long serialVersionUID = 2935135477086734036L;
	
	private List<EqualCouponsStandard> equalCouponsStandards;
	private List<DiscountCouponsStandard> discountCouponsStandards;
	
	private CouponsService couponsService;
	
	public String show() {
		equalCouponsStandards = couponsService.getEqualCoupons();
		discountCouponsStandards = couponsService.getDiscountCoupons();
		return SUCCESS;
	}
	
	public String addEqualCouponsStandard() {
		String inputString = request.getParameter("equalCoupons");
		couponsService.addEqualCouponsStandard(inputString);
		return SUCCESS;
	}
	
	public String addDiscountCouponsStandard() {
		String inputString = request.getParameter("discountCoupons");
		couponsService.addDiscountCouponsStandard(inputString);
		return SUCCESS;
	}

	public List<EqualCouponsStandard> getEqualCouponsStandards() {
		return equalCouponsStandards;
	}

	public List<DiscountCouponsStandard> getDiscountCouponsStandards() {
		return discountCouponsStandards;
	}

	public void setCouponsService(CouponsService couponsService) {
		this.couponsService = couponsService;
	}
	
	
}
