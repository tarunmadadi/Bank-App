package com.app.bankapp.vo;

import java.io.Serializable;

public class CustomerVO implements Serializable {
	private static final long serialVersionUID = 1003982984289L;
	
	private String firstName;
	private String lastName;
	private String ssnLast4;
	private String zipCode;
	private String email;

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
	public String getSsnLast4() {
		return ssnLast4;
	}
	public void setSsnLast4(String ssnLast4) {
		this.ssnLast4 = ssnLast4;
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
			.append("ssn - XXX-XX-")
			.append(ssnLast4)
			.append(", ")
			.append("zipCode - ")
			.append(zipCode)
			.append(", ")
			.append("email - ")
			.append(email)
			.append("]").toString();
	}

}
