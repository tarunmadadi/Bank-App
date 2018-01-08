package com.app.bankapp.builder;

import com.app.bankapp.model.Customer;

/**
 * Creating this builder Class for Customer so that hard coded data can be populated in the repository class
 * 
 */

public class CustomerBuilder implements Builder<Customer> {
	
	private Customer customer;
	
	/**
	 * Constructs a Builder instance
	 * @return
	 */
	public static CustomerBuilder newBuilder() {
		return new CustomerBuilder();
	}
	
	private CustomerBuilder () {
		customer = new Customer();
	}
	
	public CustomerBuilder withFirstName(String firstName) {
		customer.setFirstName(firstName);
		return this;
	}
	public CustomerBuilder withLastName(String lastName) {
		customer.setLastName(lastName);
		return this;
	}
	
	public CustomerBuilder withId(String id) {
		customer.setId(id);
		return this;
	}
	
	public CustomerBuilder withZipCode(String zipCode) {
		customer.setZipCode(zipCode);
		return this;
	}
	
	public CustomerBuilder withEmail(String email) {
		customer.setEmail(email);
		return this;
	}
	
	
	/**
	 * Returns the constructed Customer instance
	 */
	@Override
	public Customer build() {
		return customer;
	}

}
