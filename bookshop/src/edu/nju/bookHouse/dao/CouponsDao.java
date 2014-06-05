package edu.nju.bookHouse.dao;

import java.util.List;

import edu.nju.bookHouse.model.DiscountCoupons;
import edu.nju.bookHouse.model.DiscountCouponsStandard;
import edu.nju.bookHouse.model.EqualCoupons;
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

	public EqualCouponsStandard getEqualCouponsStandard(int equalId) {
		return (EqualCouponsStandard) daoHelper.findById(EqualCouponsStandard.class, equalId);
	}
	
	public DiscountCouponsStandard getDiscountCouponsStandard(int discountId) {
		return (DiscountCouponsStandard) daoHelper.findById(DiscountCouponsStandard.class, discountId);
	}

	public void addEqualCoupons(EqualCoupons equalCoupons) {
		daoHelper.save(equalCoupons);
	}
	
	public void addDiscountCoupons(DiscountCoupons coupons) {
		daoHelper.save(coupons);
	}

	public EqualCoupons getEqualCoupons(int id) {
		return (EqualCoupons) daoHelper.findById(EqualCoupons.class, id);
	}
	
	public DiscountCoupons getDiscountCoupons(int id) {
		return (DiscountCoupons) daoHelper.findById(DiscountCoupons.class, id);
	}
}
