package com.operation.crud.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.operation.crud.model.Department;
import com.operation.crud.model.DepartmentRepository;

@RunWith(SpringRunner.class)
public class DepartmentServiceTest {
	
	@Mock
	private DepartmentRepository departmentRepository;
	
	private DepartmentService departmentService;
	
	private Department department;
	
	@Before
	public void setup() {
		
		department=new Department(1,"Developing","Pune");
	}
	
	@Test
	public void getDepartmentByIdTest() {
		departmentService = new DepartmentServiceImpl(departmentRepository);
		
		Mockito.when(departmentRepository.findById(1)).thenReturn(Optional.of(department));
		
		Department department1= departmentService.getDepartment(1);
		
		Assert.assertEquals(1,department1.getDeptId());
	}
	@Test
	public void getDepartmentByNameTest() {
		
        departmentService = new DepartmentServiceImpl(departmentRepository);
		
		Mockito.when(departmentRepository.findByname("Developing")).thenReturn(Optional.of(department));
		
		Optional<Department> department1= departmentService.getDepartmentByName("Developing");
		
		Assert.assertEquals("Developing",department1.get().getName());
	}  
	
	@Test
	public void getDepartmentByLocationTest() {

        departmentService = new DepartmentServiceImpl(departmentRepository);
		
		Mockito.when(departmentRepository.findBylocation("Pune")).thenReturn(Optional.of(department));
		
		Optional<Department> department1= departmentService. getDepartmentByLocation("Pune");
		
		Assert.assertEquals("Pune",department1.get().getLocation());
	}
	@Test
	public void  addDepartmentTest() {
		
		   departmentService = new DepartmentServiceImpl(departmentRepository);
			
			Mockito.when(departmentRepository.save(department)).thenReturn(department);
			
			Department department1= departmentService.addDepartment(department);
			
			Assert.assertEquals("Developing",department1.getName());
	}
	
	@Test
	public void  updateDepartmentTest() {
		
		   departmentService = new DepartmentServiceImpl(departmentRepository);
			
			Mockito.when(departmentRepository.save(department)).thenReturn(department);
			
			Department department1= departmentService.updateDepartment(department, 1);
			
			Assert.assertEquals("Developing",department1.getName());
	}

/*	@Test
	public void deleteDepartmentTest()
	{

        departmentService = new DepartmentServiceImpl(departmentRepository);
		
		Mockito.when(departmentRepository.findBylocation("Developing")).thenReturn(Optional.of(department));
		
		Optional<Department> department1= departmentService. getDepartmentByLocation("Pune");
		
		Assert.assertEquals("Developing",department1.get().getName());
	} */ 
}
