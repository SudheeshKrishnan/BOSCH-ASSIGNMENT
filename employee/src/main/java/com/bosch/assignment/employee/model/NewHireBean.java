package com.bosch.assignment.employee.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Required;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details of new employee")
public class NewHireBean {
	@Size(min = 2,max=20)
	@ApiModelProperty(notes = "name should be minimum of 2 characters")
	private String name;

	private String gender;
	@Past
	private Date dateOfHire;

	private String city;
	private String line1;
	private String line2;

	private String band;

	private String skill;

	protected NewHireBean() {

	}

	public NewHireBean(String name, String gender, Date dateOfHire, String city, String line1, String line2,
			String band) {
		super();
		this.name = name;
		this.gender = gender;
		this.dateOfHire = dateOfHire;
		this.city = city;
		this.line1 = line1;
		this.line2 = line2;
		this.band = band;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfHire() {
		return dateOfHire;
	}

	public void setDateOfHire(Date dateOfHire) {
		this.dateOfHire = dateOfHire;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
}
