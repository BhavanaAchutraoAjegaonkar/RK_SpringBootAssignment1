package com.cts.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.product.dao.EmployeeDao;
import com.cts.product.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeDao empDao;
	
	
	@Override
	@Transactional
	public void saveEmployee(Employee emp) {
		empDao.saveEmployee(emp);
	}


	@Override
	@Transactional
	public List<Employee> viewEmployee() {
		return empDao.viewEmployee();
	}
	
	
	
}




