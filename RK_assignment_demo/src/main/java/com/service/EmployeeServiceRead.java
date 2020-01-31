package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeServiceRead 
{
	Employee findById(String empId);

	List<Employee> findByName(String empName);

	List<Employee> findAll();

}
