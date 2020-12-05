package com.bosch.assignment.employee.service;

import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.bosch.assignment.employee.constants.Constants;
import com.bosch.assignment.employee.custom.error.UserNotFoundException;
import com.bosch.assignment.employee.entity.Address;
import com.bosch.assignment.employee.entity.Department;
import com.bosch.assignment.employee.entity.Employee;
import com.bosch.assignment.employee.entity.Payroll;
import com.bosch.assignment.employee.entity.Project;
import com.bosch.assignment.employee.model.AllocateBean;
import com.bosch.assignment.employee.model.NewHireBean;
import com.bosch.assignment.employee.repository.DepartmentSpringDataRepository;
import com.bosch.assignment.employee.repository.EmployeeSpringDataRepository;
import com.bosch.assignment.employee.repository.PayrollSpringDataRepository;
import com.bosch.assignment.employee.repository.ProjectSpringDataRepository;

@Service

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeSpringDataRepository employeeRepository;

	@Autowired
	DepartmentSpringDataRepository departmentRepository;

	@Autowired
	PayrollSpringDataRepository payrollRepositor;

	@Autowired
	ProjectSpringDataRepository projectRepository;

	@Autowired
	MessageSource messageSource;

	@Override
	@Transactional
	public Employee createEmployee(NewHireBean newhire) {

		Address address = new Address();
		address.setCity(newhire.getCity());
		address.setLine1(newhire.getLine1());
		address.setLine2(newhire.getLine2());

		Employee emp = new Employee();

		emp.setDate_joined(newhire.getDateOfHire());
		emp.setGender(newhire.getGender());
		emp.setName(newhire.getName());
		emp.setSkill(newhire.getSkill());
		emp.setStatus(Constants.PROBATION);
		emp.setAddress(address);

		return employeeRepository.save(emp);

	}

	@Override
	public Employee getEmployee(long id) {

		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isEmpty())
			throw new UserNotFoundException("User with id-" + id +" "+ "has not found");
		return emp.get();

	}

	@Override
	@Transactional
	public Employee updateEmployee(AllocateBean allocateBean, long id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		Optional<Department> department = departmentRepository.findById(allocateBean.getDep_id());
		Optional<Payroll> payroll = payrollRepositor.findById(allocateBean.getPayroll_id());
		Optional<Project> project = projectRepository.findById(allocateBean.getProject_id());

		if (employee.isEmpty())
			return employee.get();
		// return "No such employees present with id {}" + id;
		else if (department.isEmpty())
			// return "No such department present with id {}" + allocateBean.getDep_id();
			return employee.get();
		else if (payroll.isEmpty())
			// return "No such payroll present with id {}" + allocateBean.getPayroll_id();
			return employee.get();
		else if (project.isEmpty())
			return employee.get();

		// return "No such project present with id {}" + allocateBean.getProject_id();
		else

		{
			Employee employeeToupdate = employee.get();

			employeeToupdate.setDepartment(department.get());

			employeeToupdate.setPayroll(payroll.get());
			employeeToupdate.addProject(project.get());

			return employeeRepository.save(employeeToupdate);

		}

	}

	@Override

	public Payroll createPayroll(Payroll payroll) {

		return payrollRepositor.save(payroll);

	}

	@Override

	public Project createProject(Project project) {
		return projectRepository.save(project);

	}

	@Override

	public Department createDepartment(Department department) {
		return departmentRepository.save(department);

	}

	@Override
	@Transactional
	public Employee confirmEmployee(long id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		Employee emp = employee.get();
		emp.setStatus(Constants.CONFIRMED);

		return emp;

	}

	@Override
	public String removeEmployee(long id, Locale locale) {
		employeeRepository.deleteById(id);

		String response = messageSource.getMessage("employee.notification.message", null, locale);

		return response;
	}

	@Override
	public Project getProjectInfo(long id) {

		return projectRepository.findById(id).get();

	}

}