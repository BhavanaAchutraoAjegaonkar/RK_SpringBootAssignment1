package com.cts.product;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cts.product.config.AppConfig;
import com.cts.product.dao.ProductDaoImpl;
import com.cts.product.model.Product;

public class Test {

	public static void main(String[] args) {
		
		AbstractApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		System.out.println("--- Stated..");
		
		
		ProductDaoImpl dao=ac.getBean(ProductDaoImpl.class);
		
		Product prod=new Product();
		prod.setProductId(103);
		prod.setProductName("Telephone");
		prod.setPrice(65.00);
		
		System.out.println("New Product is Created................");
		dao.saveProduct(prod); //Create new Product.
		
		System.out.println("Find by Name................");
		dao.findByName("Test").forEach(product->{
			System.out.println(product.getProductId());
			System.out.println(product.getProductName());
			System.out.println(product.getPrice());
			System.out.println("-----------------------------");
		});
		
		System.out.println("Find by id................");
		Product product=dao.findById(101);
		
		if(product!=null) {
			System.out.println(product.getProductId());
			System.out.println(product.getProductName());
			System.out.println(product.getPrice());
			System.out.println("-----------------------------");
		}else {
			System.out.println("Product id not found");
		}
		
		System.out.println("Find all................");
		List<Product> prods=dao.findAll_V1();
		
		
		for(Product product1:prods) {
			System.out.println(product1.getProductId());
			System.out.println(product1.getProductName());
			System.out.println(product1.getPrice());
			System.out.println("-----------------------------");
		}
		
	
		//System.out.println("Total: "+dao.findAll().size());
		
	
		
		
	
		
		System.out.println("Product in between Range of price................");
		
		//Assignment.
		
		List<Product>prod1=dao.findRange(100,500);
		
		for(Product pp:prod1)
		{
			System.out.println(pp.getProductId());
			System.out.println(pp.getProductName());
			System.out.println(pp.getPrice());
		}
		
		System.out.println("Product in between product id  numbers................");
		List<Product>prod2=dao.findProductNumbers(101,104);
		for(Product pp1:prod2)
		{
			System.out.println(pp1.getProductId());
			System.out.println(pp1.getProductName());
			System.out.println(pp1.getPrice());
		}
		
		System.out.println("Product after delete................");
		int result=dao.deleteProduct(102);
		System.out.println("Product Data Deleted Sucessfully................"+result);
		
		System.out.println("Product after Update................");
		int result1=dao.updateProduct(101);
		System.out.println("Product Data Updated Sucessfully................"+result1);
	

		
/*	System.out.println("Product after update................");
	List<Product>prod4=dao.updateProduct(104);
		for(Product pp4:prod4)
	{
		System.out.println(pp4.getProductId());
		System.out.println(pp4.getProductName());
		System.out.println(pp4.getPrice());
		}*/
		
		
		ac.close();

	}

}
