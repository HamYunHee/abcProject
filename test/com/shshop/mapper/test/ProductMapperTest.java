package com.shshop.mapper.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shshop.domain.Product;
import com.shshop.mapper.ProductMapper;
import com.shshop.util.MyBatisUtil;

public class ProductMapperTest {

	SqlSession sqlSession = null;
	ProductMapper productMapper = null;

	@Before
	public void setUp() throws Exception {
		sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		productMapper = sqlSession.getMapper(ProductMapper.class);
	}

	@After
	public void tearDown() throws Exception {
		sqlSession.rollback();
		sqlSession.close();
	}

	@Test
	public void testGetProductById() {
		Product product = productMapper.getProductById(1);
		assertNotNull("testGetProductById", product);
	}

	@Test
	public void testInsertProduct() {
		int countBefore = productMapper.getProductCount();
		productMapper.insertProduct(new Product(3, "product6", 60, 60, true, true, "tag8", false, "description6", 0));
		productMapper.insertProduct(new Product(1, "product7", 70, 70, true, false, null, false, "description7", 10));
		int countAfter = productMapper.getProductCount();
		assertEquals("testInsertProduct", countBefore + 2, countAfter);
	}

	@Test
	public void testUpdateProduct() {
		Product product = productMapper.getProductById(1);
		String nameBefore = product.getName();
		product.setName("newName");
		productMapper.updateProduct(product);
		product = productMapper.getProductById(1);
		assertTrue("testUpdateProduct", product.getName().equalsIgnoreCase("newName"));
	}

	@Test
	public void testDeleteProduct() {
		int countBefore = productMapper.getProductCount();
		productMapper.deleteProduct(1);
		int countAfter = productMapper.getProductCount();
		assertEquals("testInsertProduct", countBefore-1, countAfter);
	}
}
