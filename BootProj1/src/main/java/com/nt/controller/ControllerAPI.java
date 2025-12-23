package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class ControllerAPI {
	
	@Autowired
	private IEmployeeService empservice;
	
	@PostMapping("/add")
	public String saveEmpDetails(@RequestBody Employee emp) {
	    System.out.println(emp);
	    return empservice.addEmpData(emp);
	}

	
	@GetMapping("/view")
	public List<Employee> ViewEmpDetailsByIds() 
	{	List<Employee> list=empservice.findAllEmpData(List.of(1,2));	
		if(list.size()!=0)
			return list;
		return list;	
	}
	
	//Delete employee by ids
	@DeleteMapping("/delete")
	public String deleteElementByIdinBatch() 
	{
		String msg=empservice.deleteElementByIdinBatch(List.of());		
		return msg;
	}
	
	
	// Register or Update Employee
		@PutMapping("/update")
		public String registerOrUpdateEmp(@RequestBody Employee emp) {
		    System.out.println(emp);
		    return empservice.registerOrUpdate(emp);
		}

		
		@GetMapping("/search")
		public List<Employee> showEmployeeByData() {
		    Employee emp = new Employee();
		    emp.setName("Carry");
		    emp.setAddr("HYD");
		    List<Employee> list = empservice.showEmployeeByData(emp, true, "salary");
		   // System.out.println(list);

		    return list;
		}
		

		@GetMapping("/pagination")
		public String showEmployeeByPagination(@RequestParam(defaultValue = "3") int pageSize) {
		    System.out.println("======= Employee Records (Paginated) =======");
		    empservice.showEmployeeBypagination(pageSize);
		    System.out.println("============================================");
		    return "Employee data printed in console with page size = " + pageSize;
		}
		
		
		
		




}




