package com.shshop.helper;

import java.util.ArrayList;
import java.util.List;

import com.shshop.domain.Category;

public class CategoryHtmlBuilder {
	private String name;
	private List<CategoryHtmlBuilder> items = new ArrayList<>();

	public CategoryHtmlBuilder(String name) {
		this.name = name;
	}
	
	public CategoryHtmlBuilder(Category category) {
		this.name = category.getName();
	}	

	@Override
	public String toString() {
		if (items.isEmpty())
			return "<li><a href=\"#\">" + getName() + "</a></li>";
		return "<li><a href=\"#\" class=\"choice\">" + getName() + "</a>";// </li>";
	}

	public void add(CategoryHtmlBuilder menuComponent) {
		items.add(menuComponent);
	}

	public void remove(CategoryHtmlBuilder menuComponent) {
		items.remove(menuComponent);
	}

	public CategoryHtmlBuilder getChild(int i) {
		return items.get(i);
	}

	public String getName() {
		return name;
	}

	public String buildHtml() {
		String result = "";
		
		result += this.toString() + "\r\n";

		boolean hasItem = !items.isEmpty();

		if (hasItem)
			result += "<ul class=\"allcategory\">"+ "\r\n";

		for (int i = 0; i < items.size(); i++) {
			result += items.get(i).buildHtml();
		}

		if (hasItem)
			result += "</ul></li>"+ "\r\n";
		
		return result;
	}
}
