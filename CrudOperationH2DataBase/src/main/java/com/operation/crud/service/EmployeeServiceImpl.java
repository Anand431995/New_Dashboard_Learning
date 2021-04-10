package com.operation.crud.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operation.crud.model.Employee;
import com.operation.crud.model.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	//@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository empRepo) {
		this.empRepo=empRepo;
	}
	
	public List<Employee> getEmployeeByDepartmentId(int id) {
	
		return empRepo.findBydeptId(id);
	}
	
	public Optional<Employee> getEmployee(int id) {
		
		return empRepo.findById(id);
		
	}
	public Optional<Employee> getEmployeeByName(String name) {
		
		return empRepo.findByname(name);
	}
	
	public Employee addEmployee(Employee emp) {
		
		return empRepo.save(emp);
	}
	public void deleteEmployee(int id) {
		
		empRepo.deleteById(id);
	}
	public void deleteEmployeeByName(String name) {
		
		empRepo.deleteByname(name);
	}
	
	public void deletefordepartment(List<Integer> a) {
		
		for(int i=0;i<a.size();i++) {
			empRepo.deleteById(a.get(i));
		}
		
	}
	
	public Employee updateEmployee(Employee emp,int empId) {
		
		return empRepo.save(emp);
	}

}
