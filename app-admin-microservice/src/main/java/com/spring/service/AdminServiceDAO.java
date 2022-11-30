package com.spring.service;

import java.util.Optional;

import com.spring.dto.AdminDTO;
import com.spring.entity.Admin;

public interface AdminServiceDAO {
	
	public String saveAdmin(AdminDTO admin);
	
	public String adminLogin(String username, String password);

}
