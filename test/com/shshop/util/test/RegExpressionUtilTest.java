package com.shshop.util.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shshop.util.RegExpressionUtil;

public class RegExpressionUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void emailAddressValidationTest() {
		assertTrue(RegExpressionUtil.isValidEmail("xxxxx@naver.com"));
	}
	
	@Test
	public void emailAddressValidationTest2() {
		assertTrue(!RegExpressionUtil.isValidEmail("xxxxx@naver"));
	}

}
