package com.bosch.assignment.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.bosch.assignment.employee.model.Administartor;
import com.bosch.assignment.employee.model.EnvironmentAdmin;

@SpringBootApplication

public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Profile("dev")
	@Bean(name = "admin")
	public EnvironmentAdmin getDevAdmin() {
		return new Administartor(1, "John", "John@gmail.com");
	}

	@Profile("qa")
	@Bean(name = "admin")
	public EnvironmentAdmin getQaAdmin() {
		return new Administartor(1, "Sudheesh", "Sudheesh@gmail.com");
	}

	@Profile("prod")
	@Bean(name = "admin")
	public EnvironmentAdmin getProdAdmin() {
		return new Administartor(1, "Martin", "martin@gmail.com");
	}

	@Bean(name = "admin")
	public EnvironmentAdmin getDefaultAdmin() {
		return new Administartor(1, "Chandru", "Chandru@gmail.com");
	}
	

}
