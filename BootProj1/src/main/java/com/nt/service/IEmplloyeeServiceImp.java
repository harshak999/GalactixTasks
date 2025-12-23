	package com.nt.service;
	
	import java.util.List;
	import java.util.Optional;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.nt.entity.Employee;
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
		public List<Employee> findAllEmpData(List<Integer> ids)
		{
	
	       List<Employee> list=empRepo.findAllById(ids);
			//	list.forEach(System.out::println);
			return list;
		}
	
	
	
	
		@Override
		public String deleteElementByIdinBatch(List<Integer> ids) {
	
			List<Employee> list=empRepo.findAllById(ids);
			if(list.size()!=0)
			{
				empRepo.deleteAllByIdInBatch(ids);
				return list.size()+"no of records are";
			}
			
			return "no records are found  for deletion";
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
	}
