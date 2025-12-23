package com.nt.runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeService;

//@Component
public class EmployeeTestRunner implements CommandLineRunner {


	@Autowired
	private IEmployeeService empService;
 

	@Override
	public void run(String... args) throws Exception {

		

		try
		{
			Employee emp=new Employee("Larry","HYD",90000.0);
			String msg= empService.addEmpData(emp);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
