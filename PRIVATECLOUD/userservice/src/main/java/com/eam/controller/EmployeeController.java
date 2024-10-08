package com.eam.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.eam.dto.Message;
import com.eam.entity.Employee;
import com.eam.service.EmployeeService;

@RestController
@RequestMapping("employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@Autowired
	RestClient restClient;
	
	@GetMapping("/hello")
	public Message sayHelloMethod() {

        // Logging various log level messages 
        logger.trace("Log level: TRACE"); 
        logger.info("Log level: INFO"); 
        logger.debug("Log level: DEBUG"); 
        logger.error("Log level: ERROR"); 
        logger.warn("Log level: WARN"); 
		
		return new Message("Hello from employee controller service");
		
	}
	
	@PostMapping("/hello")
	public Message saveEmployee(@RequestBody Employee employee) {
		logger.info("Say Hello post method......" + employee.toString());
        // Logging various log level messages 
        logger.trace("Log level: TRACE"); 
        logger.info("Log level: INFO"); 
        logger.debug("Log level: DEBUG"); 
        logger.error("Log level: ERROR"); 
        logger.warn("Log level: WARN"); 
		
		return new Message("Hello from post method");
	}
	
	@PostMapping("/saveEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		ServiceInstance loginService = loadBalancerClient.choose("EAM-API-GATEWAY");
		System.out.println(loginService.getUri().toString());

		restClient.get().uri(loginService.getUri().toString()+"/login/hello").retrieve().body(String.class);
		
		String response = restClient.post() 
				  .uri(loginService.getUri().toString()+"/login/register") 

				  .body(employee) 
				  .retrieve()
				  .body(String.class);
		
		System.out.println(response);
		

		logger.info("employee : " + employee);
		
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping(value = "/getEmployeeById/{id}")
	public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable("id") Long id) {
		logger.info("id : " +id);
		Employee employee = employeeService.getEmployeeById(id);
		List<Employee> employeesList = new ArrayList<>();
		employeesList.add(employee);
		return new ResponseEntity<List<Employee>>(employeesList, HttpStatus.OK);
	}
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		logger.info(" getAllEmployees called");
		List<Employee> employeesList = employeeService.getAllemployees();
		return new ResponseEntity<List<Employee>>(employeesList, HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeeByEmail/{emailid}")
	public Employee getEmployeeByEmail(@PathVariable(value = "emailid") String emailid) {
		logger.info("emailid : " + emailid);
		return employeeService.getEmployeeByEmail(emailid);
	}
}
