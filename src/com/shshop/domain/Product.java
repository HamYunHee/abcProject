package com.shshop.domain;

import java.io.Serializable;
import java.sql.Date;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private int productId;
	private int userId;
	private String name;
	private int price;
	private int stock;
	private boolean onSale;
	private boolean onOpen;
	private String tag;
	private Date dateCreated;
	private Date dateUpdated;
	private boolean outOfStock;
	private String description;
	private User user;
	private int searchingCount;

	public Product() {

	}
	 
	public Product(int userId, String name, int price, int stock, 
				   boolean onSale, boolean onOpen, String tag, boolean outOfStock, 
				   String description, int searchingCount) {
		this.userId = userId;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.onSale = onSale;
		this.onOpen = onOpen;
		this.tag = tag;
		this.outOfStock = outOfStock;
		this.description = description;
		this.searchingCount = searchingCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isOnSale() {
		return onSale;
	}

	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}

	public boolean isOnOpen() {
		return onOpen;
	}

	public void setOnOpen(boolean onOpen) {
		this.onOpen = onOpen;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public boolean isOutOfStock() {
		return outOfStock;
	}

	public void setOutOfStock(boolean outOfStock) {
		this.outOfStock = outOfStock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getSearchingCount() {
		return searchingCount;
	}

	public void setSearchingCount(int searchingCount) {
		this.searchingCount = searchingCount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
