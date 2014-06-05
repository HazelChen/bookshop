package edu.nju.bookHouse.service;

import java.util.List;

import edu.nju.bookHouse.dao.CouponsDao;
import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.DiscountCoupons;
import edu.nju.bookHouse.model.DiscountCouponsStandard;
import edu.nju.bookHouse.model.EqualCoupons;
import edu.nju.bookHouse.model.EqualCouponsStandard;

public class CouponsService {
	private static final String EQUAL_NOT_ADDED_STRING = "equal coupons";
	private static final String DISCOUNT_NOT_ADDED_STRING = "discount coupons";
	
	private CouponsDao couponsDao;
	
	public List<EqualCouponsStandard> getEqualCoupons() {
		return couponsDao.getEqualCoupons();
	}

	public List<DiscountCouponsStandard> getDiscountCoupons() {
		return couponsDao.getDiscountCoupons();
	}

	public void addEqualCouponsStandard(String inputString) {
		Double equalValue = Double.parseDouble(inputString);
		EqualCouponsStandard standard = new EqualCouponsStandard(equalValue);
		couponsDao.addEqualCouponsStandard(standard);
	}

	public void addDiscountCouponsStandard(String inputString) {
		Double discountValue = Double.parseDouble(inputString);
		DiscountCouponsStandard standard = new DiscountCouponsStandard(discountValue);
		couponsDao.addDiscountCouponsStandard(standard);
	}

	public void setCouponsDao(CouponsDao couponsDao) {
		this.couponsDao = couponsDao;
	}

	public void send(String equalString, String discountString, CustomerInfo customerInfo) {
		if (!equalString.equals(EQUAL_NOT_ADDED_STRING)) {
			int equalId = getCouponsIdFromSend(equalString);
			EqualCouponsStandard standard = couponsDao.getEqualCouponsStandard(equalId);
			EqualCoupons equalCoupons = new EqualCoupons(standard, customerInfo);
			couponsDao.addEqualCoupons(equalCoupons);
		}
		
		if (!discountString.equals(DISCOUNT_NOT_ADDED_STRING)) {
			int discountId = getCouponsIdFromSend(discountString);
			DiscountCouponsStandard standard = couponsDao.getDiscountCouponsStandard(discountId);
			DiscountCoupons discountCoupons = new DiscountCoupons(standard, customerInfo);
			couponsDao.addDiscountCoupons(discountCoupons);
		}
	}
	
	private int getCouponsIdFromSend(String couponString) {
		int delimiterIndex = couponString.indexOf('-');
		String rightString = couponString.substring(1, delimiterIndex);
		int id = Integer.parseInt(rightString);
		return id;
	}

	public EqualCoupons getEqualCoupons(String equalId) {
		int id = Integer.parseInt(equalId);
		EqualCoupons equalCoupons = couponsDao.getEqualCoupons(id);
		return equalCoupons;
	}
	
	public DiscountCoupons getDiscountCoupons(String discountId) {
		int id = Integer.parseInt(discountId);
		DiscountCoupons discountCoupons = couponsDao.getDiscountCoupons(id);
		return discountCoupons;
	}
	
	public List<EqualCoupons> getEqualCoupons(CustomerInfo customerInfo) {
		return couponsDao.getEqualCoupons(customerInfo);
	}
	
	public List<DiscountCoupons> getDiscountCoupons(CustomerInfo customerInfo) {
		return couponsDao.getDiscountCoupons(customerInfo);
	}
}
