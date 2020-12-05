package com.bosch.assignment.employee.model;

import javax.validation.constraints.NotBlank;

public class AllocateBean {
	@NotBlank(message = "dep_id is mandatory")
	public long dep_id;
	@NotBlank(message = "project_id is mandatory")
	public long project_id;
	@NotBlank(message = "payroll_id is mandatory")
	public long payroll_id;

	public AllocateBean() {

	}

	public AllocateBean(long dep_id, long project_id, long payroll_id) {
		super();
		this.dep_id = dep_id;
		this.project_id = project_id;
		this.payroll_id = payroll_id;
	}

	public long getDep_id() {
		return dep_id;
	}

	public void setDep_id(long dep_id) {
		this.dep_id = dep_id;
	}

	public long getProject_id() {
		return project_id;
	}

	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}

	public long getPayroll_id() {
		return payroll_id;
	}

	public void setPayroll_id(long payroll_id) {
		this.payroll_id = payroll_id;
	}

}
