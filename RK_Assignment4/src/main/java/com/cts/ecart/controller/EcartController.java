package com.cts.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Communication;
import com.cts.ecart.entity.Customer;
import com.cts.ecart.entity.Orders;
import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.Review;
import com.cts.ecart.service.EcartService;

@RestController
@RequestMapping("api/")
public class EcartController {

	@Autowired
	private EcartService service;

	private List<Product> prods = null;

	public EcartController() {

	}

	@PostMapping("order/{userId}")
	public Orders saveOrder(@RequestBody Orders order) {

		System.out.println("orderdetails:=" + order.toString());
		Product product = service.getProductById(order.getProduct().getProductId());
		Customer customer = service.getUserById(order.getCustomer().getUserId());
		Communication communication = service.getaddressById(order.getCommunication().getAddressId());
		order.setCustomer(customer);
		order.setProduct(product);
		order.setCommunication(communication);

		return service.saveOrder(order);

	}
	@GetMapping("orders") 
	public List<Orders> listOrders() {

		return service.listAllOrders();
	}

	@GetMapping("order/{userId}") 
	public List<Orders> getOrderByUserId(@PathVariable("userId") int userId) {
		return service.getOrderByUserId(userId);
	}

	@PostMapping("product") 
	public Product saveProduct(@RequestBody Product product) {

		return service.saveProduct(product);

	}


	
	@GetMapping("getProduct") 
	public List<Product> listProducts() {

		return service.listProduct();
	}

	@GetMapping("productById/{pId}") 
	public Product getProductById(@PathVariable("pId") int pId) {
		return service.getProductById(pId);
	}

	@GetMapping("productByName/{pName}") 
	public List<Product> getProductByName(@PathVariable("pName") String pName) {
		return service.getProductByName(pName);
	}


	
	@PutMapping("product/{pId}")
	public Product updateProductByID(@PathVariable("pId")int pId)
	{
		return service.updateProductByID(pId);
	}
	

	
	@GetMapping("review/{pId}")  
	public List<Review> listReviewByProductId(@PathVariable("pId") int pId) {
		return service.listReviewByProductId(pId);
	}

	@PutMapping("{pId}/reviews")
	public Review updateReviewById(@PathVariable("pId") int pId, @RequestParam("userId") int userId) {
		return service.updateReview(pId, userId);
	}

	@PostMapping("review") 
	public Review saveNewReview (@RequestBody Review review) {

		return service.saveNewReview(review);

	}


	
}
