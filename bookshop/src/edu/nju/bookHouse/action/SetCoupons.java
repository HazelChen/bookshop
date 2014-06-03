package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.DiscountCouponsStandard;
import edu.nju.bookHouse.model.EqualCouponsStandard;

public class SetCoupons extends BaseAction{
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
}
