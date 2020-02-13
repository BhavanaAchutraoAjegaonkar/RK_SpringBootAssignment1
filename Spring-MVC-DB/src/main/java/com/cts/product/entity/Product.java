package com.cts.product.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Product {

	private int prodId;
	private String prodName;
	private double price;
	
	private LocalDateTime date;

	private List<String> listProds;

	public List<String> getListProds() {
		return listProds;
	}

	
	
	public LocalDateTime getDate() {
		return date;
	}



	public void setDate(LocalDateTime date) {
		this.date = date;
	}



	public void setListProds(List<String> listProds) {
		this.listProds = listProds;
	}

	private Store store;

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
