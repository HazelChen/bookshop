package edu.nju.bookHouse.dao;

import java.util.List;

import edu.nju.bookHouse.model.Category;

public class CategoryDao {
	private DaoHelper daoHelper;
	
	public List<Category> getAllCategories() {
		@SuppressWarnings("unchecked")
		List<Category> categories = daoHelper.findAll(Category.class);
		return categories;
	}
	
	public Category find(String categoryString) {
		Category category = (Category) daoHelper.findById(Category.class, categoryString);
		return category;
	}

	public DaoHelper getDaoHelper() {
		return daoHelper;
	}

	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}
	
	
}
