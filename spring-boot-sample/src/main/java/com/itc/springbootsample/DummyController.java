package com.itc.springbootsample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(path="/employee/{name}", method=RequestMethod.GET)
	public ResponseEntity<Employee> findEmployees(@PathVariable("name") String firstName){
//		return new Employee(12, "Ravi");
		// Select from Employee where name = :firstName - JPQL
	
		Employee emp =  employeeRepository.findByName(firstName);
		ResponseEntity<Employee> re = null;
		if(emp == null){
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else{
			re = new ResponseEntity<>(emp, HttpStatus.OK);
		}
		System.out.println(emp);
		return re;
		
	}
	@RequestMapping(path="/employees", method=RequestMethod.GET)
	public List<Employee> findEmployees(){
		return employeeRepository.findAll();
	}
	
	@RequestMapping(path="/employee", method=RequestMethod.POST)
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee){
		Employee emp =  employeeRepository.findByName(employee.getName());
		ResponseEntity<Void> re = null;
		if(emp == null){
			employeeRepository.save(employee);
			re = new ResponseEntity<>(HttpStatus.CREATED);
		}
		else{
			// Already exists
			re = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return re;
		
	}

}
