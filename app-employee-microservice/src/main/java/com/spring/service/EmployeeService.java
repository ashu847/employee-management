package com.spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.dto.EmployeeDTO;
import com.spring.entity.Employee;
import com.spring.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceDAO{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String registerEmployee(EmployeeDTO employee) {
		Optional<Employee> emp = employeeRepository.findByUsername(employee.getUsername());
		if(!emp.isPresent()) {
			Employee setEmployee = new Employee();
			setEmployee.setName(employee.getName());
			setEmployee.setMobile(employee.getMobile());
			setEmployee.setUsername(employee.getUsername());
			setEmployee.setPassword(employee.getPassword());
			employeeRepository.save(setEmployee);
			return "Employee Added Successfully!";
		}
		return "Employee Already Exists!";
	}

	@Override
	public String loginEmployee(String username, String password) {
		Optional<Employee> employee = employeeRepository.findByUsername(username);
		if(employee.isPresent()) {
			if(employee.get().getUsername().equals(username) && employee.get().getPassword().equals(password)) {
				return "Employee";
			}
			else {
				return "Wrong username and password";
			}
		}
		return "Register Before Login!";
	}

	@Override
	public List<Employee> listEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public String updateEmployee(Employee employee) {
		if(employeeRepository.existsById(employee.getEmployeeId())) {
			employeeRepository.save(employee);
			return "Employee with "+employee.getEmployeeId()+ " Updated!";
		}
		return "Employee with "+employee.getEmployeeId()+" not found";
	}

	@Override
	public String deleteEmployee(String id) {
		employeeRepository.deleteById(id);
		return "Employee Deleted Successfully!";
	}

	@Override
	public Optional<Employee> getEmployeeById(String username) {
		if(employeeRepository.existsByUsername(username)) {
			return employeeRepository.findByUsername(username);
		}
		return null;
	}
	
	

}
