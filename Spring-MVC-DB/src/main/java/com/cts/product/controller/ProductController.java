package com.cts.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.product.entity.Employee;
import com.cts.product.service.EmployeeService;

@Controller
public class ProductController {

	@Autowired
	private EmployeeService es;

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}

	// load employee dform

	@RequestMapping("loadForm")
	public String loadForm() {
		return "employeeform";
	}

	

	@RequestMapping("saveEmployee")
	public void saveEmployee(@ModelAttribute Employee emp) {

		es.saveEmployee(emp);

	}
	@RequestMapping("viewForm")
	public String viewForm() {
		return "emp";

	}
	@RequestMapping("viewEmployee")
	public String viewEmployee(Model model){
		
		model.addAttribute("employee", new Employee());
		model.addAttribute("viewEmployee", es.viewEmployee());
		
		
		return "emp";
		
		
		
		
		
	}
}
