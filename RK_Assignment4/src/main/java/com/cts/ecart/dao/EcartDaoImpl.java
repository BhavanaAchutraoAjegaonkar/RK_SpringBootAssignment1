package com.cts.ecart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.ecart.entity.Communication;
import com.cts.ecart.entity.Customer;
import com.cts.ecart.entity.Orders;
import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.Review;

@Repository
public class EcartDaoImpl implements EcartDao {

	@Autowired
	private SessionFactory sf;

	public Product saveProduct(Product prod) {
		sf.getCurrentSession().save(prod);
		System.out.println("Saved");
		return prod;
	}

	public List<Product> listProduct() {
		List<Product> productList = sf.getCurrentSession().createQuery("from Product").list();
		System.out.println(productList.size());
		return productList;
	}

	public List<Orders> getOrderByUserId(int userId) {

		Query query = sf.getCurrentSession().createQuery("from Orders where user_id = :uId");
		query.setInteger("uId", userId);
		Object queryResult = query.getResultList();
		return (List<Orders>) queryResult;
	}

	public List<Orders> listAllOrders() {

		List<Orders> orderList = sf.getCurrentSession().createQuery("from Orders").list();
		return orderList;

	}

	public Product getProductById(int pId) {

		Query query = sf.getCurrentSession().createQuery("from Product where product_id = :pId");
		query.setInteger("pId", pId);
		Object queryResult = query.uniqueResult();
		return (Product) queryResult;

	}

	public List<Product> getProductByName(String name) {

		Query query = sf.getCurrentSession().createQuery("from Product where productName = :pName");
		query.setParameter("pName", name);
		Object queryResult = query.getResultList();
		return (List<Product>) queryResult;

	}

	public List<Review> listReviewByProductId(int pId) {
		Query query = sf.getCurrentSession().createQuery("from Review where product_id = :pId");
		query.setInteger("pId", pId);
		Object queryResult = query.getResultList();
		return (List<Review>) queryResult;

	}

	public Review updateReview(int pId, int userId) {
		Query query = sf.getCurrentSession().createQuery("from Review where product_id = :pId and user_id = :userId");
		query.setInteger("pId", pId);
		query.setInteger("userId", userId);
		Review review = (Review) query.uniqueResult();
		review.setBody("nice Product");
		return review;

	}

	public Orders saveOrder(Orders order) {
		sf.getCurrentSession().save(order);
		System.out.println("Saved");
		return order;
	}

	public Customer getUserById(int userId) {
		Query query = sf.getCurrentSession().createQuery("from Customer where user_id = :userId");
		query.setInteger("userId", userId);
		Object queryResult = query.uniqueResult();
		return (Customer) queryResult;
	}

	public Communication getaddressById(String addressId) {
		Query query = sf.getCurrentSession().createQuery("from Communication where address_id = :addressId");
		query.setParameter("addressId", addressId);
		Object queryResult = query.uniqueResult();
		return (Communication) queryResult;
	}

	@Override
	public Product updateProductByID(int pId) {
	
		Query queary=sf.getCurrentSession().createQuery("from Product where product_id=:pId");
		queary.setInteger("pId", pId);
		Product p=(Product) queary.uniqueResult();
		p.setBrandName("LG");
		p.setProductName("TV");
		
		return p;
		
		
		
	}

	@Override
	public Review saveNewReview(Review review) {
		sf.getCurrentSession().save(review);
		System.out.println("Saved");
		return review;
	}

}
