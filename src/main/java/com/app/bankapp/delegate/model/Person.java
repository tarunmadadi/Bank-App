package com.app.bankapp.delegate.model;

import java.io.Serializable;
/**
 * This class is the response model of the person related operations
 */
public class Person implements Serializable {
	private static final long serialVersionUID = 10039857489332L;

	private String firstName;
	private String lastName;
	private String eligibility;
	
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

	public String getEligibility() {
		return eligibility;
	}
	
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
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
			.append("isEligible - ")
			.append(eligibility)
			.append("]").toString();
	}
}
