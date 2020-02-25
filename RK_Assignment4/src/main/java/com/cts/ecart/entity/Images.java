package com.cts.ecart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Images {
	
	@Id
	private int imageId;
	
	private String imagePath;

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	

}
