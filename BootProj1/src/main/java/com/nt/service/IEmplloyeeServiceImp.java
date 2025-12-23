package com.nt.service;
	
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.exception.EmployeeNotFoundException;
import com.nt.repository.IEmployeeCurdRepository;

	
	@Service
	public class IEmplloyeeServiceImp implements IEmployeeService {
	
		@Autowired
		private IEmployeeCurdRepository empRepo;
	
		
		@Override
		public String addEmpData(Employee emp) {
			Employee emp1=empRepo.save(emp);
			if(emp1.getId()!=0) {
				return "Employee no. "+emp1.getId()+" detail is added";
			}
		return "no detail is inserted !!!";
	
		}
	
	
		@Override
		public List<Employee> findAllEmpData(List<Integer> ids) {
		    List<Employee> list = empRepo.findAllById(ids);
		    if (list.isEmpty()) {
		        throw new EmployeeNotFoundException("No employees found for IDs: " + ids);
		    }
		    return list;
		}

		@Override
		public String deleteElementByIdinBatch(List<Integer> ids) {
		    List<Employee> list = empRepo.findAllById(ids);
		    if (list.isEmpty()) {
		        throw new EmployeeNotFoundException("No records found for deletion with IDs: " + ids);
		    }
		    empRepo.deleteAllByIdInBatch(ids);
		    return list.size() + " record(s) deleted successfully";
		}

	
	
		@Override
		public String registerOrUpdate(Employee emp) {
	
			Optional<Employee> opt=empRepo.findById(emp.getId());
			if(opt.isPresent())
			{
				empRepo.save(emp);
				return emp.getId()+"number Employee details Updated";
			}
			else
			{
				int idVal=empRepo.save(emp).getId();
				return idVal+"Employee  details are saved";
			}
			
		}


		@Override
		public List<Employee> showEmployeeByData(Employee data, boolean asOrder, String ...prop) {

		    ExampleMatcher matcher = ExampleMatcher.matchingAll()
		            .withIgnoreCase() // ignore case
		            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // allow partial matches
		            .withIgnoreNullValues(); // ignore nulls

		    Example<Employee> example = Example.of(data,matcher);

		    Sort sort = Sort.by(asOrder ? Sort.Direction.ASC : Sort.Direction.DESC, prop);

		    List<Employee> list=empRepo.findAll(example, sort);
		    
		    return list;
		}


		@Override
		public void showEmployeeBypagination(int pageSize) {

		    long count = empRepo.count(); // total employees in table
		    long pageCount = count / pageSize;

		    if (count % pageSize != 0)
		        pageCount++;

		    System.out.println("Total Employees: " + count);
		    System.out.println("Total Pages: " + pageCount);
		    System.out.println();

		    int totalDisplayed = 0;

		    for (int i = 0; i < pageCount; i++) {
		        Pageable pageable = PageRequest.of(i, pageSize);
		        Page<Employee> page = empRepo.findAll(pageable);

		        totalDisplayed += page.getNumberOfElements();

		        // print header line with cumulative count and page info
		        System.out.println("=== Page " + (i + 1) + " of " + pageCount +
		                " (" + totalDisplayed + "/" + (i + 1) + ") ===");

		        page.forEach(System.out::println);
		        System.out.println();
		    }
		}
                                                                              

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
