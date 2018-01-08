package com.app.bankapp.dataStore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.bankapp.model.Customer;

public final class DataStore {
	private static final Logger LOG = LoggerFactory.getLogger(DataStore.class);
	
	private static final Set<Customer> customerList = new HashSet<>();
	
	private DataStore() {}
	
	/**
	 * Adds a person instance to the {@link personList}
	 * @param person
	 * @return
	 */
	public static Customer add(Customer customer) {
		customer = customerList.add(customer) ? customer : null;
		LOG.info("Customer added - [{}]", customer);
		return customer;
	}
	/**
	 * Returns a copy of {@link personList}
	 * @return
	 */
	public static List<Customer> getCustomerList() {
		return copyOf(customerList);
	}
	
	/**
	 * Creating a copy of the original list so that the actual data do not get changed/tampered
	 * @param list
	 * @return
	 */
	private static List<Customer> copyOf(Collection<Customer> list) {
		List<Customer> copiedList = new ArrayList<>();
		for(Customer cust : list) {
			copiedList.add(new Customer(cust));
		}
		return copiedList;
	}
}
