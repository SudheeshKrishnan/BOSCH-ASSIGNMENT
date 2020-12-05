package com.bosch.assignment.employee.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String dept_name;

	private String dept_head;
	
	@OneToMany(mappedBy="department")
	private List<Employee> employees = new ArrayList<>();

	

	public void setId(Long id) {
		this.id = id;
	}

	public Department() {

	}

	public Long getId() {
		return id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_head() {
		return dept_head;
	}

	public void setDept_head(String dept_head) {
		this.dept_head = dept_head;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void addEmployee(Employee employees) {
		this.employees.add(employees);
	}

	@Override
	public String toString() {
		return String.format("Department[%s]", dept_name);
	}
}