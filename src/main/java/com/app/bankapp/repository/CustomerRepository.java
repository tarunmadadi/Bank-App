package com.app.bankapp.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.app.bankapp.builder.CustomerBuilder;
import com.app.bankapp.dataStore.DataStore;
import com.app.bankapp.delegate.RestDelegate;
import com.app.bankapp.delegate.model.Person;
import com.app.bankapp.delegate.model.PersonRequest;
import com.app.bankapp.exception.BankAppException;
import com.app.bankapp.model.Customer;

@Component
public class CustomerRepository {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerRepository.class);
	
	private RestDelegate delegate;

	public CustomerRepository(RestDelegate delegate) {
		this.delegate = delegate;
	}
	
	public Customer addCustomer(Customer customer) {
		

		Person person = delegate.doPOST(new PersonRequest(customer), Person.class);
		
		if(StringUtils.isEmpty(person.getEligibility()) || "DENIED".equalsIgnoreCase(person.getEligibility())) {
			LOG.error("Customer status is DENIED so cannot be added as customer");
			throw new BankAppException("Person not eligible to be added as customer", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return DataStore.add(customer);
	}
	
	public Customer getCustomerById(String id) {
		Customer person = CustomerBuilder.newBuilder().withId(id).build();
		List<Customer> list = DataStore.getCustomerList();
		return list.contains(person) ? list.get(list.indexOf(person)) : null;
	}
}
