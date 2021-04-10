package com.operation.crud.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Employee {
	@Id @GeneratedValue
	@Column(name="Employee_Id")
	private int empId;
	
	@Column(name="Employee_Name")
	private String name;
	
	@Column(name="Employee_Age")
	private int age;
	
	@Column(name="Employee_Salary")
	private Double salary;
	
	@ManyToOne
	public Department departmentId;
	
	private int deptId;
	
	public Employee() {
	 super();	
	}
	
	public Employee(String name, int age, Double salary,int deptId) {
		
		super();
		
		this.name = name;
		
		this.age = age;
		
		this.salary = salary;
		
		this.deptId = deptId;
	} 
	public int getEmpId() {
		return empId;
	}
	
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Department getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}
	
	public int getDeptId() {
		return deptId;
	}
	
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
}
