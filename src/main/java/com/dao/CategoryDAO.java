package com.dao;

import java.util.List;

import com.model.Category;

public interface CategoryDAO 
{
public boolean saveCategory(Category category);
	
	public List<Category> list();
	
	public Category getCategoryById(int category_id);
	
	public Category removeCategoryById(int category_id);
	

}
