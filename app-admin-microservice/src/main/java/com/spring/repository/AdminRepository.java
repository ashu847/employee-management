package com.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
	
}
