package com.shshop.service.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shshop.service.CategoryControlService;

public class CategoryControlServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuildHtml() {
		CategoryControlService categoryControlService = new CategoryControlService();
		System.out.println(categoryControlService.buildHtml());
		assertTrue("testBuildHtml",true);
	}

}
