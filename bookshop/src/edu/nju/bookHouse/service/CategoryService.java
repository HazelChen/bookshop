package edu.nju.bookHouse.service;

import java.util.List;

import edu.nju.bookHouse.dao.CategoryDao;
import edu.nju.bookHouse.model.Category;

public class CategoryService {
	private CategoryDao categoryDao;
	
	public List<Category> getAll() {
		return categoryDao.getAllCategories();
	}
	
	public Category find(String category) {
		return categoryDao.find(category);
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	
}
