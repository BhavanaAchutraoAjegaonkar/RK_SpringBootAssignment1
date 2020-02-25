package com.cts.ecart.entity;

import javax.persistence.Entity;

//@Entity
public class ProductImages {

	
	private int imageId;
	
	private int productId;

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
