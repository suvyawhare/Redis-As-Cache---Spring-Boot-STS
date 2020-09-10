package com.svregistration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.svregistration.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

}
