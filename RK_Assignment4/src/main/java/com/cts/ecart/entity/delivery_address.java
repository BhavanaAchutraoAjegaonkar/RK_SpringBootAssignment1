package com.cts.ecart.entity;

import javax.persistence.Entity;

//@Entity
public class delivery_address {
	
	private int userId;
	
	private int addressId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	
}
