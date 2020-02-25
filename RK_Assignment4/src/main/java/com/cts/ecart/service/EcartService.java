package com.cts.ecart.service;

import java.util.List;

import com.cts.ecart.entity.Communication;
import com.cts.ecart.entity.Customer;
import com.cts.ecart.entity.Orders;
import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.Review;

public interface EcartService {

	Product saveProduct(Product prod);

	Product getProductById(int pId);

	List<Product> getProductByName(String name);

	List<Product> listProduct();

	List<Orders> getOrderByUserId(int userId);

	List<Orders> listAllOrders();

	List<Review> listReviewByProductId(int pId);

	Review updateReview(int pId, int userId);

	Orders saveOrder(Orders order);

	Customer getUserById(int userId);

	Communication getaddressById(String addressId);
	
	Product updateProductByID(int pId);
	
	
	Review saveNewReview(Review review);



}