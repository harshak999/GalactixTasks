package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeService {
	
	public String addEmpData(Employee emp);
	public List<Employee> findAllEmpData(List<Integer> ids);
	public String deleteElementByIdinBatch(List<Integer> ids);
	public String registerOrUpdate(Employee emp);
	
	public List<Employee> showEmployeeByData(Employee data,boolean asOrder,String ...prop);
	public void  showEmployeeBypagination(int pageSize);

}
