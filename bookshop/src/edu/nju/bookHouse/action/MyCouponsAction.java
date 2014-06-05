package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.DiscountCoupons;
import edu.nju.bookHouse.model.EqualCoupons;
import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.CouponsService;

public class MyCouponsAction extends BaseAction{
	private static final long serialVersionUID = -2118033317242333727L;
	
	private List<EqualCoupons> equalCoupons;
	private List<DiscountCoupons> discountCoupons;
	
	private CouponsService couponsService;
	
	@Override
	public String execute() {
		User user = (User)session.get("customer");
		CustomerInfo customerInfo = user.getCustomerInfo();
		
		equalCoupons = couponsService.getEqualCoupons(customerInfo);
		discountCoupons = couponsService.getDiscountCoupons(customerInfo);
		return SUCCESS;
	}

	public List<EqualCoupons> getEqualCoupons() {
		return equalCoupons;
	}

	public List<DiscountCoupons> getDiscountCoupons() {
		return discountCoupons;
	}

	public void setCouponsService(CouponsService couponsService) {
		this.couponsService = couponsService;
	}
}
