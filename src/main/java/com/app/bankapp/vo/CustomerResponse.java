package com.app.bankapp.vo;

import java.io.Serializable;

import com.app.bankapp.model.Customer;

public class CustomerResponse implements Serializable {
	private static final long serialVersionUID = 1003982984289L;
	
	private String firstName;
	private String lastName;
	private String id;
	private String zipCode;
	private String email;
	private String message;
	
	public CustomerResponse() {
	}
	
	public CustomerResponse(Customer cust) {
		if(cust == null) {
			return;
		}
		this.firstName = cust.getFirstName();
		this.lastName = cust.getLastName();
		this.id = cust.getId();
		this.zipCode = cust.getZipCode();
		this.email = cust.getEmail();
		this.message = "OK";
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Person [")
			.append("firstName - ")
			.append(firstName)
			.append(", ")
			.append("lastName - ")
			.append(lastName)
			.append(", ")
			.append("id - ")
			.append(id)
			.append(", ")
			.append("zipCode - ")
			.append(zipCode)
			.append(", ")
			.append("email - ")
			.append(email)
			.append("]").toString();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
