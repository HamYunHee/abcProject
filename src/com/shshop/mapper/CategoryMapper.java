package com.shshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shshop.domain.Category;
import com.shshop.domain.Product;

public interface CategoryMapper {
	public int getCategoryCount();
	
	public Category getCategoryById(@Param("categoryId") int categoryId);
	
	public List<Category> getChildrenCategories(Category category);
	
	public List<Category> getRootCategories();
	
	public List<Product> getAllProducts(@Param("categoryId") int categoryId);
 
	public void insertRootCategory(Category category);
	
	public void insertChildCategory(Category category);
	
	public void updateCategory(Category category);

	public void deleteCategory(@Param("categoryId") int categoryId);
}
