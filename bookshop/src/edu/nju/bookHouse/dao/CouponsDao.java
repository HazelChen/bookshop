package edu.nju.bookHouse.dao;

import java.util.List;

import edu.nju.bookHouse.model.DiscountCouponsStandard;
import edu.nju.bookHouse.model.EqualCouponsStandard;

public class CouponsDao {
	private DaoHelper daoHelper;

	@SuppressWarnings("unchecked")
	public List<EqualCouponsStandard> getEqualCoupons() {
		return daoHelper.findAll(EqualCouponsStandard.class);
	}

	@SuppressWarnings("unchecked")
	public List<DiscountCouponsStandard> getDiscountCoupons() {
		return daoHelper.findAll(DiscountCouponsStandard.class);
	}

	public void addEqualCouponsStandard(EqualCouponsStandard standard) {
		daoHelper.save(standard);
	}

	public void addDiscountCouponsStandard(DiscountCouponsStandard standard) {
		daoHelper.save(standard);
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}
}
