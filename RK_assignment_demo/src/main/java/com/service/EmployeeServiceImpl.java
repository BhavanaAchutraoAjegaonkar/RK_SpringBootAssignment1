package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.EmployeeDao;
import com.Dao.EmployeeDaoImpl;
import com.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao empdao;
	

	public EmployeeServiceImpl(EmployeeDao empdao) {
		super();
		this.empdao = empdao;
	}

	public boolean saveEmployee(Employee emp) {
		System.out.println("EmpSERVICEImpl: saveEmployeemethod");

		return empdao.saveEmployee(emp);
	}

	public Employee findById(String empId) {
		// TODO Auto-generated method stub
		System.out.println("EmpServiceImpl: find by id method");
		return empdao.findById(empId);
	}

	public List<Employee> findByName(String empName) {
		System.out.println("EmpServiceImpl: find by name method");
		return empdao.findByName(empName);
	}

	public List<Employee> findAll() {
		System.out.println("EmpServiceImpl: find all method");
		return empdao.findAll();
	}

	public boolean deleteById(String empId) {
		// TODO Auto-generated method stub
		return empdao.deleteById(empId);
	}
}
