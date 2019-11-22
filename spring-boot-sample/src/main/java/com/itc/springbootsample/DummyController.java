package com.itc.springbootsample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
//	localhost:8000/employee/2
	@RequestMapping(path="/employee/{id}", method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") int id){
		System.out.println("******** " + id);
		employeeRepository.deleteById(id);
	}
	
	@RequestMapping(path="/employee", method=RequestMethod.GET)
	public List<Employee> findEmployee(){
//		return new Employee(12, "Ravi");
		return employeeRepository.findAll();
	}
	
	@RequestMapping(path="/employee", method=RequestMethod.POST)
	public void addEmployee(@RequestBody Employee employee){
		employeeRepository.save(employee);
	}

}
