package com.svregistration.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.svregistration.custexception.ResourceNotFoundException;
import com.svregistration.model.Employee;
import com.svregistration.repo.IEmployeeRepository;
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public Employee saveEmployee(Employee e) {
		
		return repo.save(e);
	
	}

	@Override
	public Employee updateEmployee(Integer id, Employee e) {
		// TODO Auto-generated method stub
		Employee emp=repo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not Exist"));
		emp.setEmpName(e.getEmpName());
		emp.setEmpSal(e.getEmpSal());
		return repo.save(e);
	}

	@Override
	public void deleteEmployee(Integer e) {
		Employee emp=repo.findById(e)
				.orElseThrow(()->new ResourceNotFoundException("Employee not Exist"));		
		repo.delete(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	@Cacheable("employee")
	public Employee getOneEmployee(Integer id) {
		Employee emp=repo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not Exist"));		
	
		
		return emp;
	}

}
