package edu.nju.bookHouse.dao;

import java.util.List;

import edu.nju.bookHouse.model.Category;
import edu.nju.bookHouse.model.analyse.CategoryAnalyse;

public class CategoryDao {
	private DaoHelper daoHelper;
	private StaticsDaoHelper sDaoHelper;
	
	public List<Category> getAllCategories() {
		@SuppressWarnings("unchecked")
		List<Category> categories = daoHelper.findAll(Category.class);
		return categories;
	}
	
	public Category find(String categoryString) {
		Category category = (Category) daoHelper.findById(Category.class, categoryString);
		return category;
	}


	public void add(CategoryAnalyse categoryAnalyse) {
		sDaoHelper.save(categoryAnalyse);
	}
	
	public void setDaoHelper(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
	}

	public void setsDaoHelper(StaticsDaoHelper sDaoHelper) {
		this.sDaoHelper = sDaoHelper;
	}

	public void removeAllAnalyse() {
		@SuppressWarnings("unchecked")
		List<CategoryAnalyse> categoryAnalyses = sDaoHelper.findAll(CategoryAnalyse.class);
		sDaoHelper.removeAll(categoryAnalyses);
	}

	public CategoryAnalyse findCategoryAnalyse(String categoryString) {
		return (CategoryAnalyse) sDaoHelper.findById(CategoryAnalyse.class, categoryString);
	}

	@SuppressWarnings("unchecked")
	public List<CategoryAnalyse> findAllCategoryAnalyse() {
		return sDaoHelper.findAll(CategoryAnalyse.class);
	}
}
