package edu.nju.bookHouse.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import edu.nju.bookHouse.model.analyse.AvgInventory;
import edu.nju.bookHouse.model.analyse.BookInventory;

public class InventoryDao {
	private StaticsDaoHelper daoHelper;
	
	public void add(AvgInventory avgInventory, List<BookInventory> bookInventories) {
		daoHelper.save(avgInventory);
		
		for (BookInventory bookInventory : bookInventories) {
			daoHelper.save(bookInventory);
		}
	}

	public void setDaoHelper(StaticsDaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	public AvgInventory getIdMax() {
		@SuppressWarnings("unchecked")
		List<AvgInventory> avgInventories = (List<AvgInventory>) daoHelper.findMax(AvgInventory.class, "id");
		if (avgInventories.size() == 0) {
			return null;
		} else {
			return avgInventories.get(0);
		}
	}

	public List<BookInventory> getBookInventories(AvgInventory avgInventory) {
		ArrayList<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("avgInventory", avgInventory));
		@SuppressWarnings("unchecked")
		List<BookInventory> bookInventories = daoHelper.find(BookInventory.class, expressions);
		return bookInventories;
	}
}
