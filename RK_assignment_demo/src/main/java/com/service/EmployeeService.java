package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService
{
	boolean saveEmployee(Employee emp);

	Employee findById(String empId);

	List<Employee> findByName(String empName);

	List<Employee> findAll();

	boolean deleteById(String empId);
}
