package edu.nju.bookHouse.dao;

import edu.nju.bookHouse.model.User;

public class UserDao {
	private DaoHelper daoHelper;
	
	public User find(String username) {
		return (User)daoHelper.findById(User.class, username);
	}
	
	public void add(User user) {
		daoHelper.save(user);
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}
	
	
}
