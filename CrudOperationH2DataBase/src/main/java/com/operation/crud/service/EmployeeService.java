package com.operation.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.operation.crud.model.Employee;

public interface EmployeeService {
	public List<Employee> getEmployeeByDepartmentId(int id);
	public Optional<Employee> getEmployee(int id);
	public Optional<Employee> getEmployeeByName(String name);
	public Employee addEmployee(Employee emp);
	public void deleteEmployee(int id);
	public void deleteEmployeeByName(String name);
	public void deletefordepartment(List<Integer> a);
	public Employee updateEmployee(Employee emp,int empId);

}
