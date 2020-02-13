package com.cts.product.service;

import java.util.List;

import com.cts.product.entity.Employee;

public interface EmployeeService {

	void saveEmployee(Employee emp);
	List<Employee>viewEmployee();


}