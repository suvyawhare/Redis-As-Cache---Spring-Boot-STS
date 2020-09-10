package com.svregistration.sevice;

import java.util.List;

import com.svregistration.model.Employee;

public interface IEmployeeService {
	public Employee saveEmployee(Employee e);
	public Employee updateEmployee(Integer id,Employee e);
	public void deleteEmployee(Integer e);
	public List<Employee> getAllEmployee();
	public Employee getOneEmployee(Integer e);
}
