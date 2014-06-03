package edu.nju.bookHouse.dao;

import edu.nju.bookHouse.model.BookCollected;

public class CollectedBookDao {
	private DaoHelper daoHelper;
	
	public void add(BookCollected bookCollected) {
		daoHelper.save(bookCollected);
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}
}
