package com.luv2code.springboot.cruddemo.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Utilities.PdfGen;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {		
		List<Employee> theEmployees = employeeService.findAll();
		
		
		theModel.addAttribute("employees", theEmployees);
		return "/employees/list-employees";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "/employees/employee-form";
	}
	
	@RequestMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable("id") int id){
		
		employeeService.deleteById(id);
	    return "redirect:/employees/list";
	 }
	 
	 @RequestMapping("/edit/{id}")
	 public String editEmployeeById(Model theModel, @PathVariable("id") int id){	
		
		 Employee theEmployees=employeeService.findById(id);
		 theModel.addAttribute("employee", theEmployees);
		 return "/employees/employee-form";
	 }
	@RequestMapping("/generate")
	public String pdfGenerate() {
		List<Employee> theEmployees = employeeService.findAll();
		PdfGen pdf = new PdfGen();
		pdf.generatePdf(theEmployees);
		return "redirect:/employees/list";
	}
}





