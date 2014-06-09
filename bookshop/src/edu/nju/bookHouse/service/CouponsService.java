package edu.nju.bookHouse.service;

import java.util.Iterator;
import java.util.List;

import edu.nju.bookHouse.dao.CouponsDao;
import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.DiscountCoupons;
import edu.nju.bookHouse.model.DiscountCouponsAnalyse;
import edu.nju.bookHouse.model.DiscountCouponsStandard;
import edu.nju.bookHouse.model.EqualCoupons;
import edu.nju.bookHouse.model.EqualCouponsAnalyse;
import edu.nju.bookHouse.model.EqualCouponsStandard;
import edu.nju.bookHouse.model.OrderForm;

public class CouponsService {
	private static final String EQUAL_NOT_ADDED_STRING = "equal coupons";
	private static final String DISCOUNT_NOT_ADDED_STRING = "discount coupons";
	
	private CouponsDao couponsDao;
	
	public void analyse() {
		couponsDao.removeAllAnalyse();
		analyseEquals();
		analyseDiscount();
	}
	
	private void analyseDiscount() {
		List<DiscountCouponsStandard> standards = couponsDao.getDiscountCouponsStandards();
		int allCount = 0;
		int allUsed = 0;
		for (DiscountCouponsStandard standard : standards) {
			int total = standard.getDiscountCoupons().size();
			allCount += total;
			Iterator<DiscountCoupons> iterator = standard.getDiscountCoupons().iterator();
			int used = 0;
			while (iterator.hasNext()) {
				DiscountCoupons coupons = iterator.next();
				if (coupons.getCustomerInfo() == null) {
					used++;
				}
			}
			allUsed += used;
			double percent = ((int)((used + 0.0) / total * 100)) / 100.0;
			DiscountCouponsAnalyse analyse = new DiscountCouponsAnalyse(standard.getDiscount() + "", 
					total, used, percent);
			couponsDao.add(analyse);
		}
		double allPercent = ((int)((allUsed + 0.0) / allCount * 100)) / 100.0;
		DiscountCouponsAnalyse analyse = new DiscountCouponsAnalyse("total", allCount, allUsed, allPercent);
		couponsDao.add(analyse);
	}

	private void analyseEquals() {
		List<EqualCouponsStandard> standards = couponsDao.getEqualCouponsStandards();
		int allCount = 0;
		int allUsed = 0;
		for (EqualCouponsStandard standard : standards) {
			int total = standard.getEqualCoupons().size();
			allCount += total;
			Iterator<EqualCoupons> iterator = standard.getEqualCoupons().iterator();
			int used = 0;
			while (iterator.hasNext()) {
				EqualCoupons coupons = iterator.next();
				if (coupons.getCustomerInfo() == null) {
					used++;
				}
			}
			allUsed += used;
			double percent = ((int)((used + 0.0) / total * 100)) / 100.0;
			EqualCouponsAnalyse analyse = new EqualCouponsAnalyse(standard.getEqualValue() + "", 
					total, used, percent);
			couponsDao.add(analyse);
		}
		double allPercent = ((int)((allUsed + 0.0) / allCount * 100)) / 100.0;
		EqualCouponsAnalyse analyse = new EqualCouponsAnalyse("total", allCount, allUsed, allPercent);
		couponsDao.add(analyse);
	}

	public List<EqualCouponsStandard> getEqualCoupons() {
		return couponsDao.getEqualCouponsStandards();
	}

	public List<DiscountCouponsStandard> getDiscountCoupons() {
		return couponsDao.getDiscountCouponsStandards();
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

	public void useEqualCoupons(EqualCoupons equalCoupons, OrderForm orderForm) {
		equalCoupons.setCustomerInfo(null);
		equalCoupons.setOrderForm(orderForm);
		couponsDao.update(equalCoupons);
	}
	
	public void useDiscountCoupons(DiscountCoupons discountCoupons, OrderForm orderForm) {
		discountCoupons.setCustomerInfo(null);
		discountCoupons.setOrderForm(orderForm);
		couponsDao.update(discountCoupons);
	}
}
