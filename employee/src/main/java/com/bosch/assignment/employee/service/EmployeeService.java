package com.bosch.assignment.employee.service;

import java.util.Locale;

import com.bosch.assignment.employee.entity.Department;
import com.bosch.assignment.employee.entity.Employee;
import com.bosch.assignment.employee.entity.Payroll;
import com.bosch.assignment.employee.entity.Project;
import com.bosch.assignment.employee.model.AllocateBean;
import com.bosch.assignment.employee.model.NewHireBean;

public interface EmployeeService {

	Employee createEmployee(NewHireBean newhire);

	Employee getEmployee(long id);

	Employee updateEmployee(AllocateBean allocateBean, long id);

	Payroll createPayroll(Payroll payroll);

	Project createProject(Project project);

	Department createDepartment(Department department);

	Employee confirmEmployee(long id);

	String removeEmployee(long id, Locale locale);

	Project getProjectInfo(long id);

}
