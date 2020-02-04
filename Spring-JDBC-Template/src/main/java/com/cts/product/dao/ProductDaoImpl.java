package com.cts.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.product.model.Product;

@Repository
public class ProductDaoImpl {

	@Autowired
	private JdbcTemplate jt;

	/*
	 * DRL
	 * 
	 * 1. ResultsetExtractor 
	 * 2.RowCallbackHandler 
	 * 3. RowMapper
	 */

	public List<Product> findAll() {
		
		List<Product> prods=  jt.queryForObject("select * from product", new RowMapperDemo());

		return prods;
	}

	public List<Product> findAll_V1() {
		
		List<Product> prods=  jt.query("select * from product", new ResultSetExtractorDemo());

		return prods;
	}

public List<Product> findByName(String productName) {
		List<Product> prods=  jt.query("select * from product where product_name like ?", new ResultSetExtractorDemoByName(),"%"+productName+"%");
		return prods;
	}
	

//display product By id:
public Product findById(int prodId) {
	return jt.query("select * from product where product_id=?", new ResultSetExtractorDemoById(),prodId);
}
	
	
	public int saveProduct(Product prod) {
		int noOfRowsEffected = jt.update("insert into product values(?,?,?)", prod.getProductId(),
				prod.getProductName(), prod.getPrice());
		return noOfRowsEffected;
	}
	
	
	
	//Assignment.
	
	
public List<Product> findRange(double price1,double price2) {
		
	List<Product> prods=  jt.query("select * from product where price between ? and ?", new ResultSetExtractorDemoByRange(),price1,price2);

		return prods;
	}




public List<Product> findProductNumbers(int prod1,int prod2) {
	
	List<Product> prods=  jt.query("select distinct * from product where product_id between ? and ?", new ResultSetExtractorDemoByProductNumber(),prod1,prod2);

		return prods;
	}


public int deleteProduct(int prodid) {
	
	int prods=  jt.update("delete from product where product_id=?",prodid);

		return prods;
	}


public int updateProduct(int prodid) {
	//Product p=new Product();
	
	int prods=  jt.update("update product set product_name=? where product_id=? " ,"Desktop",prodid);

		return prods;
	}

}

// All Products
class ResultSetExtractorDemo implements ResultSetExtractor<List<Product>>{

	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Product> prods = new ArrayList<Product>();

		while (rs.next()) {
			Product prod = new Product();
			prod.setProductId(rs.getInt("product_id"));
			prod.setProductName(rs.getString("product_name"));
			prod.setPrice(rs.getDouble("price"));

			prods.add(prod);

		}

		return prods;
	}
	
}

// Filter by Product Name
class ResultSetExtractorDemoByName implements ResultSetExtractor<List<Product>>{

	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Product> prods = new ArrayList<Product>();

		while (rs.next()) {
			Product prod = new Product();
			prod.setProductId(rs.getInt("product_id"));
			prod.setProductName(rs.getString("product_name"));
			prod.setPrice(rs.getDouble("price"));

			prods.add(prod);

		}

		return prods;
	}
	
}

//Filter by Product Id
class ResultSetExtractorDemoById implements ResultSetExtractor <Product>{

	public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
	
		Product prod = null;
		if (rs.next()) {
			prod=	 new Product();
			prod.setProductId(rs.getInt("product_id"));
			prod.setProductName(rs.getString("product_name"));
			prod.setPrice(rs.getDouble("price"));
		}

		return prod;
	}
	
}


class RowMapperDemo implements RowMapper<List<Product>> {
	
	List<Product> prods = new ArrayList<Product>();

	public List<Product>  mapRow(ResultSet rs, int rowNum) throws SQLException {

		while (rs.next()) {
			Product prod = new Product();
			prod.setProductId(rs.getInt("product_id"));
			prod.setProductName(rs.getString("product_name"));
			prod.setPrice(rs.getDouble("price"));

			prods.add(prod);

		}

		return prods;
	}
}

//Assignment.

class ResultSetExtractorDemoByRange implements ResultSetExtractor<List<Product>>{

	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Product> prods = new ArrayList<Product>();

		while (rs.next()) {
			Product prod = new Product();
			prod.setProductId(rs.getInt("product_id"));
			prod.setProductName(rs.getString("product_name"));
			prod.setPrice(rs.getDouble("price"));

			prods.add(prod);

		}

		return prods;
	}
	
}

class ResultSetExtractorDemoByProductNumber implements ResultSetExtractor<List<Product>>{

	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Product> prods = new ArrayList<Product>();

		while (rs.next()) {
			Product prod = new Product();
			prod.setProductId(rs.getInt("product_id"));
			prod.setProductName(rs.getString("product_name"));
			prod.setPrice(rs.getDouble("price"));

			prods.add(prod);

		}

		return prods;
	}
	
}
/*
class ResultSetExtractorDemoDeleteProduct implements ResultSetExtractor<List<Product>>{

	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Product> prods = new ArrayList<Product>();

		while (rs.next()) {
			Product prod = new Product();
			prod.setProductId(rs.getInt("product_id"));
			prod.setProductName(rs.getString("product_name"));
			prod.setPrice(rs.getDouble("price"));

			prods.add(prod);

		}

		return prods;
	}
	
}*/
/*class ResultSetExtractorDemoUpdateProduct implements ResultSetExtractor<List<Product>>{

	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Product> prods = new ArrayList<Product>();

		while (rs.next()) {
			Product prod = new Product();
			prod.setProductId(rs.getInt("product_id"));
			prod.setProductName(rs.getString("product_name"));
			prod.setPrice(rs.getDouble("price"));

			prods.add(prod);

		}

		return prods;
	}
	
}
*/
