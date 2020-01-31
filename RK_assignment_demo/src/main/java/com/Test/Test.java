package com.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.AppConfig;
import com.Dao.EmployeeDao;
import com.Dao.EmployeeDaoImpl;
import com.model.Employee;
import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;
import com.service.EmployeeServiceRead;
import com.service.EmployeeServiceReadOnlyImpl;
import java.util.*;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		Scanner sc = new Scanner(System.in);

		EmployeeDao empdao = new EmployeeDaoImpl();

		EmployeeService empservice = ac.getBean(EmployeeService.class);
		EmployeeServiceRead empserviceread = ac.getBean(EmployeeServiceRead.class);

		String id;
		String name;
		int ch;

		while (true) {
			
			System.out.println("Enter choice:=");
			System.out.println("1:Admin \n 2:User \n 3:Close");
			System.out.println("Enter ur choice:=");
			int ch1 = sc.nextInt();
			
			start:
			switch (ch1) {

			case 1: 
				while (true)
				{
					System.out.println(
							"select 1:create new employee \n 2:find by id \n 3:find by name \n 4:find all employee \n 5:delete employee by id \n 6:to close.");
					System.out.println("enter ur choice:=");
					ch = sc.nextInt();

					switch (ch) {
					case 1:

						Employee empp = new Employee();
						System.out.println("enter id and name of employee to add:=");
						id = sc.next();
						name = sc.next();

						empp.setEmpid(id);
						empp.setEmpname(name);

						System.out.println(empp.getEmpid());
						System.out.println(empservice.saveEmployee(empp));// true
						break;
					case 2:
						System.out.println("enter id:=");
						String i = sc.next();
						System.out.println(empservice.findById(i));
						break;
					case 3:
						System.out.println("enter name:=");
						String n1 = sc.next();
						List<Employee> e = empservice.findByName(n1);

						for (Employee ee : e) {
							System.out.println(ee.toString());
						}
//				while (itr.hasNext()) {
//					System.out.println(itr.next());
//				}
						break;

					case 4:
						System.out.println(empservice.findAll());
						break;

					case 5:
						System.out.println("enter id to delete:=");
						String ii = sc.next();
						System.out.println("Employee Deleted successfully:=" + empservice.deleteById(ii));
						break;

					case 6:
							
							break start;
						
					}
				}




			case 2: 
			
				while (true) 
				{
					System.out.println("select 1:find by id \n 2:find by name \n 3:find all employee \n 4:to close.");
					System.out.println("enter ur choice:=");
					ch = sc.nextInt();
					switch (ch) {
					case 1:
						System.out.println("enter id:=");
						String i = sc.next();
						System.out.println(empserviceread.findById(i));
						break;

					case 2:
						System.out.println("enter name:=");
						String n1 = sc.next();
						List<Employee> e = empserviceread.findByName(n1);

						for (Employee ee : e) {
							System.out.println(ee.toString());
						}
//					while (itr.hasNext()) {
//						System.out.println(itr.next());
//					}
						break;
					case 3:
						System.out.println(empserviceread.findAll());
						break;

					case 4:
						
						break start;

					}

				}
			
			case 3:
				System.exit(0);
				break;
			
			
		}
	}
	}
}


// System.out.println();

// l1=empserviceread.findByName(name);
// System.out.println(l1.size());

// System.out.println(empserviceread.findById(id));

// System.out.println("Find by name in readonly:="+l1);
//

// System.out.println(empserviceread.findAll());

//boolean t=	empimpl.saveEmployee(emp);
//System.out.println(t);

//Employee empl=new Employee();

//empl=empimpl.findById(id);
//
//System.out.println("Id:="+empl.getEmpid()+"  "+"Name:="+empl.getEmpname());

//Employee emp1=new Employee();
//
//emp1=empr.findById(id);
//System.out.println(emp1.toString());
//	
//List<Employee>ll=empimpl.findByName(name);
//
//
