package com.cts.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.ecart.dao.EcartDao;
import com.cts.ecart.entity.Communication;
import com.cts.ecart.entity.Customer;
import com.cts.ecart.entity.Orders;
import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.Review;

@Service
public class EcartServiceImpl implements EcartService {

	@Autowired
	private EcartDao dao;

	@Transactional
	public Product saveProduct(Product prod) {
		return dao.saveProduct(prod);
	}

	@Transactional
	public List<Product> listProduct() {
		return dao.listProduct();
	}

	@Transactional
	public List<Orders> getOrderByUserId(int userId) {
		return dao.getOrderByUserId(userId);
	}

	@Transactional
	public List<Orders> listAllOrders() {
		return dao.listAllOrders();
	}

	@Transactional
	public Product getProductById(int pId) {
		return dao.getProductById(pId);
	}

	@Transactional
	public List<Product> getProductByName(String name) {
		return dao.getProductByName(name);
	}

	@Transactional
	public List<Review> listReviewByProductId(int pId) {
		return dao.listReviewByProductId(pId);
	}

	@Transactional
	public Review updateReview(int pId, int userId) {
		return dao.updateReview(pId, userId);
	}

	@Transactional
	public Orders saveOrder(Orders order) {
		return dao.saveOrder(order);
	}

	@Transactional
	public Customer getUserById(int userId) {
		return dao.getUserById(userId);
	}

	@Transactional
	public Communication getaddressById(String addressId) {
		return dao.getaddressById(addressId);
	}

	@Transactional
	@Override
	public Product updateProductByID(int pId) {
		
		return dao.updateProductByID(pId);
		
	}
		@Transactional
	@Override
	public Review saveNewReview(Review review) {
		return dao.saveNewReview(review);
	}

}
