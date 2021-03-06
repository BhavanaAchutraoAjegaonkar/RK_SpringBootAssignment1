package com.cts.ecart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cts.ecart.entity.Category;
import com.cts.ecart.entity.Communication;
import com.cts.ecart.entity.Customer;
import com.cts.ecart.entity.Orders;
import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.Review;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.cts.ecart.service"), @ComponentScan("com.cts.ecart.dao") })
public class AppConfig {


	
	 @Autowired private Environment env;
	 
	 // ProperyPl
	 
	 @Bean public DataSource getDataSource() { BasicDataSource dataSource = new
	 BasicDataSource();
	 dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
	 dataSource.setUrl(env.getProperty("jdbc.url"));
	 dataSource.setUsername(env.getProperty("jdbc.username"));
	 dataSource.setPassword(env.getProperty("jdbc.password")); return dataSource;
	 }
	 
	 @Bean public LocalSessionFactoryBean getSessionFactory() {
	 
	 LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	 
	 factoryBean.setDataSource(getDataSource());
	 
	 
	 Properties props = new Properties(); props.put("hibernate.show_sql",
	 env.getProperty("hibernate.show_sql")); props.put("hibernate.hbm2ddl.auto",
	 env.getProperty("hibernate.hbm2ddl.auto")); props.put("hibernate.format_sql",
	 env.getProperty("hibernate.format_sql")); props.put("hibernate.dialect",
	 env.getProperty("hibernate.dialect"));
	 factoryBean.setHibernateProperties(props);
	 
	factoryBean.setAnnotatedClasses(Product.class,Category.class,Customer.class,Orders.class,Communication.class,Review.class);
	 
	 return factoryBean; }
	 
	 @Bean public HibernateTransactionManager getTransactionManager() {
	 HibernateTransactionManager transactionManager = new
	 HibernateTransactionManager();
	 transactionManager.setSessionFactory(getSessionFactory().getObject()); return
	 transactionManager; }
	 
	

}
