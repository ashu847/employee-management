package com.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.AdminDTO;
import com.spring.entity.Admin;
import com.spring.repository.AdminRepository;

@Service
public class AdminService implements AdminServiceDAO{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public String saveAdmin(AdminDTO admin) {
		Optional<Admin> opAdmin = adminRepository.findById(admin.getUsername());
		if(!opAdmin.isPresent()) {
			Admin setAdmin = new Admin();
			setAdmin.setUsername(admin.getUsername());
			setAdmin.setPassword(admin.getPassword());
			adminRepository.save(setAdmin);
			return "Admin with "+admin.getUsername()+" created.";
		}
		return "Already present!";
	}

	@Override
	public String adminLogin(String username, String password) {
		Optional<Admin> admin = adminRepository.findById(username);
		if(admin.isPresent()) {
			if(admin.get().getUsername().equals(username) && admin.get().getPassword().equals(password)) {
				return "admin";
			}
			else {
				return "Wrong username or password!"; 
			}
		}
		return "Admin Not present!";
	}
	
	

}
