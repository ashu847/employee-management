package com.spring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	Optional<Employee> findByUsername(String username);

	boolean existsByUsername(String username);

}
