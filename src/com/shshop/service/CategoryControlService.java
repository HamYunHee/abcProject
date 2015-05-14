package com.shshop.service;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.shshop.domain.Category;
import com.shshop.helper.CategoryHtmlBuilder;
import com.shshop.mapper.CategoryMapper;
import com.shshop.util.MyBatisUtil;

public class CategoryControlService {
	private SqlSession sqlSession = null;
	private CategoryMapper categoryMapper = null;

	public CategoryControlService() {

	}

	public String buildHtml() {
		String result = "";

		try {
			CategoryMapper categoryMapper = getCategoryMapper();
			CategoryHtmlBuilder categoryHtmlBuilderRoot = new CategoryHtmlBuilder("전체");
			
			List<Category> rootCategories = categoryMapper.getRootCategories();
			Iterator<Category> iter = rootCategories.iterator();
			while (iter.hasNext()) {
				Category category = iter.next();
				CategoryHtmlBuilder categoryHtmlBuilderChild = new CategoryHtmlBuilder(category);
				categoryHtmlBuilderRoot.add(categoryHtmlBuilderChild);
				buildHtmlRecursive(categoryHtmlBuilderChild, category);
			}
			
			result = categoryHtmlBuilderRoot.buildHtml();
		} finally {
			closeMapper();
		}

		return result;
	}

	private void buildHtmlRecursive(CategoryHtmlBuilder categoryParentItem, Category parentCategory) {
		try {
			CategoryMapper categoryMapper = getCategoryMapper();
			List<Category> rootCategories = categoryMapper.getChildrenCategories(parentCategory);
			
			Iterator<Category> iter = rootCategories.iterator();
			while (iter.hasNext()) {
				Category nextCategory = iter.next();
				CategoryHtmlBuilder categoyBuilderChild = new CategoryHtmlBuilder(nextCategory);
				categoryParentItem.add(categoyBuilderChild);
				buildHtmlRecursive(categoyBuilderChild, nextCategory);
			}
		} finally {
			closeMapper();
		}
	}

	private void closeMapper() {
		if (sqlSession != null)
			sqlSession.close();
	}

	private CategoryMapper getCategoryMapper() {
		sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

		return sqlSession.getMapper(CategoryMapper.class);
	}
}
