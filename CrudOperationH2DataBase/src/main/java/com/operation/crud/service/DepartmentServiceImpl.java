package com.operation.crud.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.operation.crud.model.Department;
import com.operation.crud.model.DepartmentRepository;
import com.operation.crud.model.Employee;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	public DepartmentRepository deptRepo;
	
	@Autowired
	  public EmployeeService employee;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository deptRepo) {
		
	  this.deptRepo = deptRepo;	
	}
	
	public Department getDepartment(int id) {
		
		 return deptRepo.findById(id).get();
		 
	}
	
	public Optional<Department> getDepartmentByName(String name) {
		
		 return deptRepo.findByname(name);
	}
	public Optional<Department> getDepartmentByLocation(String location) {
		
		 return deptRepo.findBylocation(location);
	}
	
   public Department addDepartment(Department dept) {
	   
	  return deptRepo.save(dept);
	   
   }
   
   public void deleteDepartment(int id) {
	  int k=0;
	   List<Integer> a=new ArrayList<Integer>();
	   
	   List<Employee> emp=new ArrayList<Employee>();
	   
	   emp=employee.getEmployeeByDepartmentId(id);
	   
	   for(Employee i:emp) {
		   
		   a.add(emp.get(k++).getEmpId());
	   }
	   
	   if(a.size()!=0) {
	   
	      employee.deletefordepartment(a);
	   }
	  
	   deptRepo.deleteById(id);
   }
   
   public void deleteDepartmentByName(String name) {
	   deptRepo.deleteByname(name);
   }
   
   public void deleteDepartmentByLocation(String location) {
	   
	   deptRepo.deleteBylocation(location);
   }
   
   public Department updateDepartment(Department dept1,int deptId) {
	
	  return deptRepo.save(dept1);
	   
	   
	}
   public String checkmethod()
   {
	   return "Check employee";
   }


}
