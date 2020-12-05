package com.bosch.assignment.employee.custom.error;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;

	private String mesaage;
	private String Details;

	public ExceptionResponse(Date timestamp, String mesaage, String details) {
		super();
		this.timestamp = timestamp;
		this.mesaage = mesaage;
		Details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMesaage() {
		return mesaage;
	}

	public void setMesaage(String mesaage) {
		this.mesaage = mesaage;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}
}
