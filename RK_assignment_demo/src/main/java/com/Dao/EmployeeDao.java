package com.Dao;

import java.util.List;

import com.model.Employee;

public interface EmployeeDao {
	boolean saveEmployee(Employee emp);

	Employee findById(String empId);

	List<Employee> findByName(String empName);

	List<Employee> findAll();

	boolean deleteById(String empId);
}
