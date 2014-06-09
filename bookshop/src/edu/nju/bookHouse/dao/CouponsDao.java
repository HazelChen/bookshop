package edu.nju.bookHouse.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.DiscountCoupons;
import edu.nju.bookHouse.model.DiscountCouponsAnalyse;
import edu.nju.bookHouse.model.DiscountCouponsStandard;
import edu.nju.bookHouse.model.EqualCoupons;
import edu.nju.bookHouse.model.EqualCouponsAnalyse;
import edu.nju.bookHouse.model.EqualCouponsStandard;

public class CouponsDao {
	private DaoHelper daoHelper;
	private StaticsDaoHelper sDaoHelper;

	@SuppressWarnings("unchecked")
	public List<EqualCouponsStandard> getEqualCouponsStandards() {
		return daoHelper.findAll(EqualCouponsStandard.class);
	}

	@SuppressWarnings("unchecked")
	public List<DiscountCouponsStandard> getDiscountCouponsStandards() {
		return daoHelper.findAll(DiscountCouponsStandard.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<EqualCoupons> getEqualCoupons() {
		return daoHelper.findAll(EqualCoupons.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<DiscountCoupons> getDiscountCoupons() {
		return daoHelper.findAll(DiscountCoupons.class);
	}

	public void addEqualCouponsStandard(EqualCouponsStandard standard) {
		daoHelper.save(standard);
	}

	public void addDiscountCouponsStandard(DiscountCouponsStandard standard) {
		daoHelper.save(standard);
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
	
	public List<EqualCoupons> getEqualCoupons(CustomerInfo customerInfo) {
		ArrayList<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("customerInfo", customerInfo));
		@SuppressWarnings("unchecked")
		List<EqualCoupons> equalCoupons = daoHelper.find(EqualCoupons.class, expressions);
		return equalCoupons;
	}
	
	public List<DiscountCoupons> getDiscountCoupons(CustomerInfo customerInfo) {
		ArrayList<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("customerInfo", customerInfo));
		@SuppressWarnings("unchecked")
		List<DiscountCoupons> equalCoupons = daoHelper.find(DiscountCoupons.class, expressions);
		return equalCoupons;
	}

	public void update(EqualCoupons equalCoupons) {
		daoHelper.updateNotMerge(equalCoupons);
	}
	
	public void update(DiscountCoupons discountCoupons) {
		daoHelper.updateNotMerge(discountCoupons);
	}

	@SuppressWarnings("unchecked")
	public void removeAllAnalyse() {
		List<EqualCouponsAnalyse> equalCouponsAnalyses = sDaoHelper.findAll(EqualCouponsAnalyse.class);
		sDaoHelper.removeAll(equalCouponsAnalyses);
		List<DiscountCouponsAnalyse> discountCouponsAnalyses = sDaoHelper.findAll(DiscountCouponsAnalyse.class);
		sDaoHelper.removeAll(discountCouponsAnalyses);
	}
	
	
	
	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	public void add(EqualCouponsAnalyse analyse) {
		sDaoHelper.save(analyse);
	}
	
	public void add(DiscountCouponsAnalyse analyse) {
		sDaoHelper.save(analyse);
	}

	public void setsDaoHelper(StaticsDaoHelper sDaoHelper) {
		this.sDaoHelper = sDaoHelper;
	}
}
