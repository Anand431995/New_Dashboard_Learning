package com.operation.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.operation.crud.model.Department;

public interface DepartmentService {
	
   public Department getDepartment(int id);
   public Optional<Department> getDepartmentByName(String name);
   public Optional<Department> getDepartmentByLocation(String location);
   public Department addDepartment(Department dept);
   public void deleteDepartment(int id);
   public void deleteDepartmentByName(String name);
   public void deleteDepartmentByLocation(String location);
   public Department updateDepartment(Department dept,int deptId);
}
