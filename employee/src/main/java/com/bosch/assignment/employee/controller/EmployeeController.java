package com.bosch.assignment.employee.controller;

import java.net.URI;
import java.util.Locale;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bosch.assignment.employee.entity.Department;
import com.bosch.assignment.employee.entity.Employee;
import com.bosch.assignment.employee.entity.Payroll;
import com.bosch.assignment.employee.entity.Project;
import com.bosch.assignment.employee.model.AllocateBean;
import com.bosch.assignment.employee.model.EnvironmentAdmin;
import com.bosch.assignment.employee.model.NewHireBean;
import com.bosch.assignment.employee.service.EmployeeService;

@RestController
@CrossOrigin("/*")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	MessageSource messageSource;
	@Autowired(required = false)
	EnvironmentAdmin admin;

	@PostMapping("/employee")

	ResponseEntity<Object> createEmployee(@Valid @RequestBody NewHireBean newHire) {

		Employee employee = employeeService.createEmployee(newHire);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@GetMapping("employee/{id}")
	Employee getAnEmployee(
			@Valid @PathVariable(required = true) @Max(value = 1000, message = "id must be lower than or equal to 1000") @NotBlank long id) {

		return employeeService.getEmployee(id);

	}

	@PostMapping("/project")

	ResponseEntity<Object> createProject(@RequestBody Project project) {

		Project prjct = employeeService.createProject(project);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prjct.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@PostMapping("/department")

	ResponseEntity<Object> createDepartment(@RequestBody Department department) {

		Department dept = employeeService.createDepartment(department);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dept.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@PostMapping("/payroll")

	ResponseEntity<Object> createpayroll(@RequestBody Payroll payroll) {

		Payroll payRoll = employeeService.createPayroll(payroll);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(payRoll.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/allocate/{id}")

	ResponseEntity<Object> allocateEmploye(@Valid @RequestBody AllocateBean allocateBean,
			@NonNull @PathVariable long id) {

		Employee employee = employeeService.updateEmployee(allocateBean, id);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@PatchMapping("/confirm/{id}")

	ResponseEntity<Object> confirmEmploye(@PathVariable long id) {

		Employee employee = employeeService.confirmEmployee(id);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/remove/{id}")

	String deleteEmployee(@PathVariable long id, Locale locale) {

		return employeeService.removeEmployee(id, locale);

	}

	@GetMapping(path = "/admin-info")
	public EnvironmentAdmin getAdminInfo() {
		return admin;
	}

	@GetMapping("/project-employee/{id}")
	public Project getProjectEmployee(@PathVariable long id) {
		return employeeService.getProjectInfo(id);

	}

}
