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
import com.operation.crud.service.DepartmentService;
import com.operation.crud.service.DepartmentServiceImpl;
@RestController
public class DepartmentController {
	
	@Autowired
	public DepartmentService department;
	
	@RequestMapping(value="/getDepartmentById/{id}")
	public Department getDepartment(@PathVariable int id) {
		 Department dept=null;
		 
		 dept=department.getDepartment(id);
		 
		 if(dept!=null) {
			 
			 return dept;
		 }
		 else {
			
			return dept;
		 }
		
	}
	@RequestMapping(value="/getDepartmentByName/{name}")
	public Optional<Department> getDepartmentByName (@PathVariable String name)	{
		
		 Optional<Department> dept=null;
		
		 dept=department.getDepartmentByName(name);
		 
		 if(dept!=null) {
			 
			 return dept;
		 }
		 else {
			
			return dept;
		 }
		
	}
	@RequestMapping(value="/getDepartmentByLocation/{location}")
	public Optional<Department> getDepartmentByLocation (@PathVariable String location) {
		 
		Optional<Department> dept=null;
	   
		dept=department.getDepartmentByLocation(location);
		 
		 if(dept!=null) {
			 
			 return dept;
		 }
		 else {
			
			return dept;
		 }
		
	}
	
    @PostMapping("/addDepartment")
	public String addDepartment(@RequestBody Department dept) {
	  
    	 department.addDepartment(dept);
    	 
    	 return "Department record has been added successfully";
	}
   
   @RequestMapping(method=RequestMethod.DELETE,value="/deleteDepartmentByName/{name}")
  	public String deleteDepartmentByName(@PathVariable String name) {
  	    
	   department.deleteDepartmentByName(name);
  		
	   return "Department details for given name deleted Successfully";
  	}
   
   @RequestMapping(method=RequestMethod.DELETE,value="/deleteDepartmentByLocation/{location}")
 	public String deleteDepartmentByLocation(@PathVariable String location) {
	   
 	    department.deleteDepartmentByLocation(location);
 		
 	    return "Department details for given location deleted Successfully";
 	}
   
   @RequestMapping(method=RequestMethod.PUT,value="/updatedepartment/{deptId}")
  	public String updateDepartment(@RequestBody Department dept ,@PathVariable int deptId) {
	   
	   department.updateDepartment(dept,deptId);
  	
	   return "Record Updated Successfully";
  	
   }
   @RequestMapping(method=RequestMethod.PUT,value="/updatedepartment/{deptId}")
 	public String updateDepartment(@RequestBody Department dept ,@PathVariable int deptId) {
	   
	   department.updateDepartment(dept,deptId);
 	
	   return "Record Updated Successfully";
 	
  }

}
