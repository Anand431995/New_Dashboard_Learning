package com.operation.crud.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer>{
public Optional<Department> findByname(String name);
public Optional<Department> findBylocation(String location);
public void deleteByname(String name);
public void deleteBylocation(String location);
}
