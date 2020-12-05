package com.bosch.assignment.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payroll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private double basic;

	private double variable;

	private String grade;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="payroll")
	private Employee employee;

	
	protected Payroll() {
	}
	
	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getVariable() {
		return variable;
	}

	public void setVariable(double variable) {
		this.variable = variable;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Grade[%s]", grade);
	}
}