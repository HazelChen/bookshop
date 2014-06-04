package edu.nju.bookHouse.action;

import java.util.List;

import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.DiscountCouponsStandard;
import edu.nju.bookHouse.model.EqualCouponsStandard;
import edu.nju.bookHouse.model.User;
import edu.nju.bookHouse.service.CouponsService;
import edu.nju.bookHouse.service.UserService;

public class SendCouponsAction extends BaseAction{
	private static final long serialVersionUID = -7210924224316746081L;

	private List<User> users;
	private List<EqualCouponsStandard> equalCouponsStandards;
	private List<DiscountCouponsStandard> discountCouponsStandards;
	
	private UserService userService;
	private CouponsService couponsService;
	
	public String show() {
		users = userService.getAllCustomers();
		equalCouponsStandards = couponsService.getEqualCoupons();
		discountCouponsStandards = couponsService.getDiscountCoupons();
		return SUCCESS;
	}
	
	public String send() {
		String equal = request.getParameter("equalCoupons");
		String discount = request.getParameter("discountCoupons");
		String customerId = request.getParameter("customerId");
		CustomerInfo customerInfo = userService.getCustomerInfo(customerId);
		couponsService.send(equal, discount, customerInfo);
		return SUCCESS;
	}

	public List<User> getUsers() {
		return users;
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

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
