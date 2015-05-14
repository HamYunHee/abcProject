package com.shshop.mapper;

import org.apache.ibatis.annotations.Param;

import com.shshop.domain.Product;

public interface ProductMapper {
	public int getProductCount();
	
	public Product getProductById(@Param("productId") int productId);
	
	public void insertProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(@Param("productId") int productId);
}
