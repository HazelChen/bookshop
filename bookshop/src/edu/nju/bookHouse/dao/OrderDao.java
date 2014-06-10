package edu.nju.bookHouse.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import edu.nju.bookHouse.model.BuyBook;
import edu.nju.bookHouse.model.CustomerInfo;
import edu.nju.bookHouse.model.OrderForm;
import edu.nju.bookHouse.model.State;
import edu.nju.bookHouse.model.analyse.DaySales;
import edu.nju.bookHouse.model.analyse.OrderShipment;

public class OrderDao {
	private DaoHelper daoHelper;
	private StaticsDaoHelper sDaoHelper;
	
	public void add(OrderForm orderForm) {
		daoHelper.save(orderForm);
	}
	
	public void add(BuyBook book) {
		daoHelper.save(book);
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	public List<OrderForm> getOrder(CustomerInfo customerInfo) {
		ArrayList<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("customerInfo", customerInfo));
		@SuppressWarnings("unchecked")
		List<OrderForm> orderForms = daoHelper.find(OrderForm.class, expressions);
		return orderForms;
	}

	public List<OrderForm> getOrder(State state) {
		ArrayList<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("state", state));
		@SuppressWarnings("unchecked")
		List<OrderForm> orderForms = daoHelper.find(OrderForm.class, expressions);
		return orderForms;
	}

	public OrderForm find(int orderId) {
		return (OrderForm)daoHelper.findById(OrderForm.class, orderId);
	}

	public void update(OrderForm orderForm) {
		daoHelper.updateNotMerge(orderForm);
	}

	public long getOrderBeforeDate(String mediateDateString) {
		String hql = "select count(*) from edu.nju.bookHouse.model.OrderForm where confirmDate < '" + mediateDateString + "'";
		@SuppressWarnings("unchecked")
		List<Long> list = daoHelper.find(hql);
		if (list.size() == 0) {
			return 0;
		}
		return list.get(0);
	}
	
	public long getOrderAfterDate(String mediateDateString) {
		String hql = "select count(*) from edu.nju.bookHouse.model.OrderForm where confirmDate >= '" + mediateDateString + "'";
		@SuppressWarnings("unchecked")
		List<Long> list = daoHelper.find(hql);
		if (list.size() == 0) {
			return 0;
		}
		return list.get(0);
	}

	public long getCountAtDate(String dateString) {
		String hql = "select count(*) from edu.nju.bookHouse.model.OrderForm where confirmDate = '" + dateString + "'";
		@SuppressWarnings("unchecked")
		List<Long> list = daoHelper.find(hql);
		if (list.size() == 0) {
			return 0;
		}
		return list.get(0);
	}

	public void add(DaySales daySales) {
		sDaoHelper.save(daySales);
	}

	public void setsDaoHelper(StaticsDaoHelper sDaoHelper) {
		this.sDaoHelper = sDaoHelper;
	}

	@SuppressWarnings("unchecked")
	public void removeAllStatics() {
		List<DaySales> daySales = sDaoHelper.findAll(DaySales.class);
		sDaoHelper.removeAll(daySales);
		List<OrderShipment> orderShipments = sDaoHelper.findAll(OrderShipment.class);
		sDaoHelper.removeAll(orderShipments);
	}

	@SuppressWarnings("unchecked")
	public List<OrderForm> getAllOrders() {
		return daoHelper.findAll(OrderForm.class);
	}

	public void add(OrderShipment orderShipment) {
		sDaoHelper.save(orderShipment);
	}

	@SuppressWarnings("unchecked")
	public List<DaySales> getAllDaySales() {
		return sDaoHelper.findAll(DaySales.class);
	}

	@SuppressWarnings("unchecked")
	public List<OrderShipment> getAllOrderShipment() {
		return sDaoHelper.findAll(OrderShipment.class);
	}
	
	
}
