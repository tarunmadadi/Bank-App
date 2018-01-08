package com.app.bankapp.bo;

import org.springframework.stereotype.Component;

import com.app.bankapp.model.Customer;
import com.app.bankapp.repository.CustomerRepository;

@Component
public class CustomerBO {
	
	private CustomerRepository repository;
	
	public CustomerBO(CustomerRepository repository) {
		this.repository = repository;
	}
	
	public Customer addCustomer(Customer customer) {
		return repository.addCustomer(customer);
	}
	
	public Customer getCustomerById(String id) {
		return repository.getCustomerById(id);
	}
}


