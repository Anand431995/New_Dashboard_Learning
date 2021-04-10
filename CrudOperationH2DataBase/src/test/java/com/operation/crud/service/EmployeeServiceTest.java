package com.operation.crud.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.operation.crud.model.*;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	private EmployeeService employeeService;
	
	private Employee employee;
	
	private List<Employee> employees = new ArrayList<Employee>();
	
	@Before
	public void setUp() {
		
		employee=new Employee();
		
		employee.setEmpId(1);
		
		employee.setAge(23);
		
		employee.setName("Anand");
		
		employee.setSalary(45000.0);
		
		employee.setDeptId(1);
		
		Employee employeeone = new  Employee("Anand",23,56000.0,1);
		
		Employee employeetwo = new  Employee("Avinash",24,66000.0,1);
		
		Employee employeethree = new  Employee("Abhishek",25,76000.0,1);
		
		employees.add(employeeone);
		
		employees.add(employeetwo);
		
		employees.add(employeethree); 
		
	}
	
	@Test
	public void getEmployeeByIdTest() {
		
		employeeService = new EmployeeServiceImpl(employeeRepository);
		
		Mockito.when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
		
	    Optional<Employee> emplist = employeeService.getEmployee(1);
	    
	    Assert.assertEquals(1,emplist.get().getEmpId());
	    
	}
	
 	@Test
	public void getEmployeeByDepartmentIdTest() {
		
		employeeService = new EmployeeServiceImpl(employeeRepository);
		
		Mockito.when(employeeRepository.findBydeptId(1)).thenReturn(employees);
		
	    List<Employee> emplist = employeeService.getEmployeeByDepartmentId(1);
	    
	    Assert.assertEquals(23,emplist.get(0).getAge());
	    
	}  
	
	@Test
	public void getEmployeeByNameTest() {
       
		employeeService = new EmployeeServiceImpl(employeeRepository);
		
		Mockito.when(employeeRepository.findByname("Anand")).thenReturn(Optional.of(employee));
		
	    Optional<Employee> emplist = employeeService.getEmployeeByName("Anand");
	    
	    Assert.assertEquals("Anand",emplist.get().getName());
	}
	
	@Test
	public void addEmployeeTest() {
       
		employeeService = new EmployeeServiceImpl(employeeRepository);
		
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		
	    Employee emplist = employeeService.addEmployee(employee);
	    
	    Assert.assertEquals("Anand",emplist.getName());
	}

	@Test
	public void updateEmployeeTest() {
       
		employeeService = new EmployeeServiceImpl(employeeRepository);
		
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		
	    Employee emplist = employeeService.updateEmployee(employee, 1);
	    
	    Assert.assertEquals("Anand",emplist.getName());
	}
}
