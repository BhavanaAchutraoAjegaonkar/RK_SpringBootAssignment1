package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Dao.EmployeeDao;
import com.Dao.EmployeeDaoImpl;
import com.model.Employee;

@Service
public class EmployeeServiceReadOnlyImpl implements EmployeeServiceRead
{
	@Autowired
	private EmployeeDao empdao;
	
	
	
	
public EmployeeServiceReadOnlyImpl(EmployeeDao empdao) {
		super();
		this.empdao = empdao;
	}



	public Employee findById(String empId) {
		System.out.println("EmployeeServiceReadOnlyImpl: Find By Id Employee method:=");
		
		return empdao.findById(empId);
		
	
		
	}

	public List<Employee> findByName(String empName) {
		
		System.out.println("EmployeeServiceReadOnlyImpl:Find by name Employee method:=");
		
		return empdao.findByName(empName);
	}

	public List<Employee> findAll() {
		System.out.println("EmployeeServiceReadOnlyImpl:Find All Employee Method:=");
		return empdao.findAll();
	}
}
