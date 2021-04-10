package com.operation.crud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import org.springframework.web.bind.annotation.Mapping;
@Entity
public class Department {
	@Id @GeneratedValue
	@Column(name="Department_Id")
	
	private int deptId;
	
	@Column(name="Department_Name")
	private String name;
	
	@Column(name="Department_Location")
	private String location;
	
	public Department() {
		
	}
	public Department(int id,String name,String location) {
		super();
		this.deptId=id;
		this.name=name;
		this.location=location;
	}
	
	public int getDeptId() {
		return deptId;
	}
	
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
}
