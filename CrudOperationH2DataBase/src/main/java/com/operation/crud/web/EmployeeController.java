package com.operation.crud.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.operation.crud.model.Department;
import com.operation.crud.model.Employee;
import com.operation.crud.service.EmployeeService;
import com.operation.crud.service.EmployeeServiceImpl;
@RestController
public class EmployeeController {
	  
	@Autowired
	  public EmployeeService employee;
	
	 @RequestMapping(value="/employees/{deptId}")
	  public List<Employee> getEmployeeByDepartmentId(@PathVariable int deptId) {
		
		 return employee.getEmployeeByDepartmentId(deptId);
	  }
	  
	  @RequestMapping(value="/getEmployeeById/{id}")
	  public Optional<Employee> getEmployee(@PathVariable int id) {
		
		  return employee.getEmployee(id);
	  }
	  
	  @RequestMapping(value="/getEmployeeByName/{name}")
	  public Optional<Employee> getEmployeeByName(@PathVariable String name) {
		
		  return employee.getEmployeeByName(name);
	  }
	  
	  @RequestMapping(method=RequestMethod.DELETE,value="/deleteEmployeeById/{id}")
	  public String deleteEmployee(@PathVariable int id) {
		   
		  employee.deleteEmployee(id);
			
		   return "Employee details for given id successfully deleted";
	  }
	  
	  @RequestMapping(method=RequestMethod.DELETE,value="/deleteEmployeeByName/{name}")
	  public String deleteEmployeeByName(@PathVariable String name) {
		    
		  employee.deleteEmployeeByName(name);
			
		  return "Employee details for given name successfully deleted";
	  }
	  
	 @PostMapping("/addEmployee")
	// @RequestMa pping(method=RequestMethod.POST,value="/addEmployee")
	  public String addEmployee(@RequestBody Employee emp) {
		 
		    emp.setDepartmentId(new Department(emp.getDeptId(),"",""));
		    
		    employee.addEmployee(emp);
			
		    return "Employee record has been added successfully";
	  }
	 
	 @RequestMapping(method=RequestMethod.PUT,value="/updateEmployee/{empId}")
	 public String updateEmployee(@RequestBody Employee emp , @PathVariable int empId) {
		    employee.updateEmployee(emp, empId);
			
		    return "Employee details successfully updated";
	 }
	

}
