package edu.nju.bookHouse.service;

import java.util.List;

import edu.nju.bookHouse.dao.CouponsDao;
import edu.nju.bookHouse.model.DiscountCouponsStandard;
import edu.nju.bookHouse.model.EqualCouponsStandard;

public class CouponsService {
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
}
