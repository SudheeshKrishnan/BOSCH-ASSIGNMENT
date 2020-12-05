package com.bosch.assignment.employee.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String project_name;

	private String project_location;
	
	
	@ManyToMany
	@JoinTable(name = "EMPLOYEE_PROJECT", joinColumns = @JoinColumn(name = "PROJECT_ID"), inverseJoinColumns = @JoinColumn(name = "EMP_ID"))
	private List<Employee> employees = new ArrayList<>();

	public Project() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_location() {
		return project_location;
	}

	public void setProject_location(String project_location) {
		this.project_location = project_location;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}

	@Override
	public String toString() {
		return String.format("Project[%s]", project_name);
	}
}