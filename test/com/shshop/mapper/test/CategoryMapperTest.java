package com.shshop.mapper.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shshop.domain.Category;
import com.shshop.mapper.CategoryMapper;
import com.shshop.util.MyBatisUtil;

public class CategoryMapperTest {
	SqlSession sqlSession = null;
	CategoryMapper categoryMapper = null;

	@Before
	public void setUp() throws Exception {
		sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		categoryMapper = sqlSession.getMapper(CategoryMapper.class);
	}

	@After
	public void tearDown() throws Exception {
		sqlSession.rollback();
		sqlSession.close();
	}

	@Test
	public void testGetCategoryById() {
		Category category = categoryMapper.getCategoryById(1);
		assertNotNull("testGetCategoryById", category);
	}

	@Test
	public void testGetChildrenCategories() {
		Category category = categoryMapper.getCategoryById(1);
		List<Category> childrenCategories = categoryMapper.getChildrenCategories(category);
		assertTrue("testGetChildrenCategories", childrenCategories.size() > 0);
	}

	@Test
	public void testGetRootCategories() {
		List<Category> rootCategories = categoryMapper.getRootCategories();
		assertTrue("testGetRootCategories", rootCategories.size() > 0);
	}

	@Test
	public void testInsertRootCategory() {
		int countBefore = categoryMapper.getCategoryCount();
		categoryMapper.insertRootCategory(new Category("test", "testDescription", "testLink"));
		int countAfter = categoryMapper.getCategoryCount();
		assertEquals("testInsertRootCategory", countBefore + 1, countAfter);
	}

	@Test
	public void testInsertChildCategory() {
		Category rootCategory = categoryMapper.getCategoryById(1);
		int countBefore = categoryMapper.getCategoryCount();
		categoryMapper.insertChildCategory(new Category(rootCategory, "test2", "testDescription2", "testLink2"));
		int countAfter = categoryMapper.getCategoryCount();
		assertEquals("testInsertChildCategory", countBefore + 1, countAfter);
	}

	@Test
	public void testUpdateCategory() {
		Category category = categoryMapper.getCategoryById(1);
		category.setName("testName");
		category.setDescription("testDesc");
		category.setLink("testLink");
		categoryMapper.updateCategory(category);
		category = categoryMapper.getCategoryById(1);
		assertTrue("testUpdateCategory1", category.getName().equalsIgnoreCase("testName"));
		assertTrue("testUpdateCategory2", category.getLink().equalsIgnoreCase("testLink"));
		assertTrue("testUpdateCategory3", category.getDescription().equalsIgnoreCase("testDesc"));
	}
	
	@Test
	public void testDeleteCategory() {
		int countBefore = categoryMapper.getCategoryCount();
		categoryMapper.deleteCategory(2);
		int countAfter = categoryMapper.getCategoryCount();
		assertTrue("testDeleteCategory", countBefore > countAfter+1);
	}
}
