package com.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.AdminDTO;
import com.spring.service.AdminServiceDAO;

@RestController
@RequestMapping(value = "/admin")
public class AdminRestController {

	@Autowired
	private AdminServiceDAO adminService;
	
	@PostMapping(value="/add" , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerAdmin(@RequestBody AdminDTO admin){
		String result = adminService.saveAdmin(admin);
		return ResponseEntity.ok("{\"status\":\""+result+"\"}");
	}
	
	@GetMapping(value="/login/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> loginEmployee(@PathVariable("username") String username, @PathVariable("password") String password){
		String result = adminService.adminLogin(username, password);
		return ResponseEntity.ok(result);
	}
	
}
