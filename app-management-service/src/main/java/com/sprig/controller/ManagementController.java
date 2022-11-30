package com.sprig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.sprig.entity.Admin;
import com.sprig.entity.Employee;



@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class ManagementController {
	
	@Autowired
	private RestTemplate rt;
	
	@PostMapping(path="/add")
	ResponseEntity<String> addAdmin(@RequestBody Admin admin){
		ResponseEntity<String> resp= rt.postForEntity("http://app-admin-microservice/admin/add", admin, String.class );
		return ResponseEntity.ok("Admin Added");
	}
	
	@PostMapping(path="/adminlogin")
	ResponseEntity<String> loginAdmin(@RequestBody Admin admin){
		ResponseEntity<String> resp= rt.getForEntity("http://app-admin-microservice/admin/login/"+admin.getUsername()+"/"+admin.getPassword(), String.class);
		return ResponseEntity.ok(resp.getBody());
	}
	
	@PostMapping(path="/empadd")
	ResponseEntity<String> addEmployee(@RequestBody Employee emp){
		ResponseEntity<String> resp= rt.postForEntity("http://app-employee-microservice/employee/register", emp, String.class );
		return ResponseEntity.ok("Employee Registered");
	}
	
	@GetMapping(path="/emplogin")
	ResponseEntity<String> empLogin(@RequestParam("username") String username, @RequestParam("password") String password){
		ResponseEntity<String> resp= rt.getForEntity("http://app-employee-microservice/employee/login/"+username+"/"+password, String.class);
		return ResponseEntity.ok(resp.getBody());
	}
	
	@GetMapping(path="/emplist")
	ResponseEntity<List<Employee>> empList(){
		ResponseEntity<List<Employee>> resp= rt.exchange(
				"http://app-employee-microservice/employee/list/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		return ResponseEntity.ok(resp.getBody());
	}
	
	@PostMapping(path="/empupdate")
	ResponseEntity<String> updateEmployee(@RequestBody Employee emp){
		ResponseEntity<String> resp= rt.postForEntity("http://app-employee-microservice/employee/update", emp, String.class );
		return ResponseEntity.ok("Employee Updated");
	}
	
	@GetMapping(path="/empdelete")
	ResponseEntity<String> empDelete(@RequestParam("id") String id){
		ResponseEntity<String> resp= rt.getForEntity("http://app-employee-microservice/employee/delete/"+id, String.class);
		return ResponseEntity.ok("Employee Deleted");
	}
	
	@GetMapping(path="/empfind")
	ResponseEntity<Employee> empFind(@RequestParam("username") String username){
		ResponseEntity<Employee> resp= rt.getForEntity("http://app-employee-microservice/employee/find/"+username, Employee.class);
		return ResponseEntity.ok(resp.getBody());
	}

}
