package com.shshop.helper.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.shshop.helper.CategoryHtmlBuilder;

public class CategoryHtmlBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMakeHtml() {
		CategoryHtmlBuilder category1 = new CategoryHtmlBuilder("1");

			CategoryHtmlBuilder catetory11 = new CategoryHtmlBuilder("11");
			category1.add(catetory11);
			CategoryHtmlBuilder category12 = new CategoryHtmlBuilder("12");
			category1.add(category12);
			
				CategoryHtmlBuilder category111 = new CategoryHtmlBuilder("111");
				CategoryHtmlBuilder category112 = new CategoryHtmlBuilder("112");
				catetory11.add(category111);
				catetory11.add(category112);

				CategoryHtmlBuilder category121 = new CategoryHtmlBuilder("121");
				CategoryHtmlBuilder category122 = new CategoryHtmlBuilder("122");
				category12.add(category121);
				category12.add(category122);

		CategoryHtmlBuilder category2 = new CategoryHtmlBuilder("2");

			CategoryHtmlBuilder category21 = new CategoryHtmlBuilder("21");
			category2.add(category21);
			CategoryHtmlBuilder category22 = new CategoryHtmlBuilder("22");
			category2.add(category22);
		
				CategoryHtmlBuilder category211 = new CategoryHtmlBuilder("211");
				CategoryHtmlBuilder category212 = new CategoryHtmlBuilder("212");
				category21.add(category211);
				category21.add(category212);

				CategoryHtmlBuilder category221 = new CategoryHtmlBuilder("221");
				CategoryHtmlBuilder category222 = new CategoryHtmlBuilder("222");
				CategoryHtmlBuilder category223 = new CategoryHtmlBuilder("223");
				CategoryHtmlBuilder category224 = new CategoryHtmlBuilder("224");
				category22.add(category221);
				category22.add(category222);
				category22.add(category223);
				category22.add(category224);

 
		String categoryResult1 = "";
		String categoryResult2 = "";
		String categoryResult1Expected = "<li><a href=\"#\" class=\"choice\">1</a>\r\n" + 
										"<ul class=\"allcategory\">\r\n" +
										"<li><a href=\"#\" class=\"choice\">11</a>\r\n" + 
										"<ul class=\"allcategory\">\r\n" +
										"<li><a href=\"#\">111</a></li>\r\n" +
										"<li><a href=\"#\">112</a></li>\r\n" +
										"</ul></li>\r\n" +
										"<li><a href=\"#\" class=\"choice\">12</a>\r\n" +
										"<ul class=\"allcategory\">\r\n" +
										"<li><a href=\"#\">121</a></li>\r\n" +
										"<li><a href=\"#\">122</a></li>\r\n" +
										"</ul></li>\r\n" +
										"</ul></li>\r\n";
		String categoryResult2Expected = "<li><a href=\"#\" class=\"choice\">2</a>\r\n" +
										"<ul class=\"allcategory\">\r\n" +
										"<li><a href=\"#\" class=\"choice\">21</a>\r\n" +
										"<ul class=\"allcategory\">\r\n" +
										"<li><a href=\"#\">211</a></li>\r\n" +
										"<li><a href=\"#\">212</a></li>\r\n" +
										"</ul></li>\r\n" +
										"<li><a href=\"#\" class=\"choice\">22</a>\r\n" +
										"<ul class=\"allcategory\">\r\n" +
										"<li><a href=\"#\">221</a></li>\r\n" +
										"<li><a href=\"#\">222</a></li>\r\n" +
										"<li><a href=\"#\">223</a></li>\r\n" +
										"<li><a href=\"#\">224</a></li>\r\n" +
										"</ul></li>\r\n" +
										"</ul></li>\r\n";
		
		categoryResult1 = category1.buildHtml();
		categoryResult2 = category2.buildHtml();
		categoryResult1.trim();
		categoryResult2.trim();
		assertTrue("testMakeHtml1", categoryResult1.equalsIgnoreCase(categoryResult1Expected));
		assertTrue("testMakeHtml2", categoryResult2.equalsIgnoreCase(categoryResult2Expected));
	}

}
