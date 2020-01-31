package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

//	@Autowired
//	private EmployeeDao empdao;

List<Employee>ll=new ArrayList<Employee>();
private List<Employee> list1;

	public boolean saveEmployee(Employee emp)
	{
		ll.add(emp);
		System.out.println("DAO:New employee created:=");
		System.out.println(ll.size());
		return true;
	}

	public Employee findById(String empId) {
		System.out.println("EmpDaoimpl:Find By ID:=");
		
		for(Employee emp:ll)
		{
		if(emp.getEmpid().equalsIgnoreCase(empId))
			return emp;
		
		}
		return null;
	}		
		
	

	public List<Employee> findByName(String empName) 
	{
		System.out.println("EmpDaoImp:Find By Name:=");
		list1 = new ArrayList<Employee>();
		for(Employee emp2:ll)
		{
		if(emp2.getEmpname().equalsIgnoreCase(empName))
			{
				list1.add(emp2);
				
			}
		}
		System.out.println(list1.size());
		return list1;
	
	}

	public List<Employee> findAll()
	{
		System.out.println("EmpDaoImpl:Find All:=");
			
		return ll;
	}

	public boolean deleteById(String empId) 
	{
		System.out.println("EmpDaoImpl:DeleteById:=");
		for(Employee emp3:ll)
		{
		if(empId.equalsIgnoreCase(emp3.getEmpid()))
		{
			ll.remove(emp3);	
			return true;
		}
		}
		return false;
		
		
	}

}
