package com.app.bankapp.dataStore;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.app.bankapp.model.Customer;

@RunWith(MockitoJUnitRunner.class)
public class DataStoreTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Mock
	private Customer mockedCustomer;
	
	
	@Test
	public void  add() {
		mockedCustomer = DataStore.add(mockedCustomer);
		assertNotNull(mockedCustomer);
		mockedCustomer = DataStore.add(mockedCustomer);
		assertEquals(null,mockedCustomer);
	}
	
	@Test
	public void getCustomerList() {
		List<Customer> customerList = DataStore.getCustomerList();
		assertNotNull(customerList);
	}
}