package com.spring.service;

import java.util.List;
import java.util.Optional;

import com.spring.dto.EmployeeDTO;
import com.spring.entity.Employee;

public interface EmployeeServiceDAO {
	
	public String registerEmployee(EmployeeDTO employee);
	
	public String loginEmployee(String username, String password);
	
	public List<Employee> listEmployee();
	
	public String updateEmployee(Employee employee);
	
	public String deleteEmployee(String id);
	
	public Optional<Employee> getEmployeeById(String username);

}
