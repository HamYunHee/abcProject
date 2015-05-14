package com.shshop.domain;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userId;
	private String name;
	private boolean gender;
	private String ktalkId;
	private String email;
	private String phone;
	private String password;
	private Date birthday;
	private boolean isDeleted;
	private boolean isGuest;
	private boolean isProducer;
	private String bankName;
	private String bankNum;
	private Date lastPasswordGenerated;
	private Date dateCreated;
	private Date dateUpdated;

	public User() {
	}
	
	public User(String email, String password, String name, String phone, String ktalkId) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.ktalkId = ktalkId;
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKtalkId(String ktalkId) {
		this.ktalkId = ktalkId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getName() {
		return name;
	}

	public String getKtalkId() {
		return ktalkId;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	public String getBankName() {
		return bankName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getLastPasswordGenerated() {
		return lastPasswordGenerated;
	}

	public void setLastPasswordGenerated(Date lastPasswordGenerated) {
		this.lastPasswordGenerated = lastPasswordGenerated;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public boolean isGuest() {
		return isGuest;
	}

	public void setGuest(boolean isGuest) {
		this.isGuest = isGuest;
	}

	public boolean isProducer() {
		return isProducer;
	}

	public void setProducer(boolean isProducer) {
		this.isProducer = isProducer;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
