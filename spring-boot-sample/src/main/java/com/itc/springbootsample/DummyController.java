package com.itc.springbootsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
public class DummyController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping(path="/hello", method=RequestMethod.GET)
	public String sayHello(){
		return "Hello everyone!!";
	}
	
	@RequestMapping(path="/employee", method=RequestMethod.GET)
	public Employee findEmployee(){
		return new Employee(12, "Ravi");
	}
	
	@RequestMapping(path="/employee", method=RequestMethod.POST)
	public void addEmployee(@RequestBody Employee employee){
		employeeRepository.save(employee);
	}

}
