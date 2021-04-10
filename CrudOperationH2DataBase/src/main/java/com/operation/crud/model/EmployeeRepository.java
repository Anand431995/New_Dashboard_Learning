package com.operation.crud.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

	
	public List<Employee> findBydeptId(int id);
	public Optional<Employee> findByname(String name);
	public void deleteByname(String name);

}
