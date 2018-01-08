package com.app.bankapp.bo;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

import com.app.bankapp.model.Customer;
import com.app.bankapp.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerBOTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@InjectMocks
	private CustomerBO underTest;
	
	@Mock
	private Customer mockedCustomer;
	
	@Mock
	private CustomerRepository mockedCustomerRepository;
	
	@Test
	public void addCustomer() throws Exception {
		
		when(mockedCustomerRepository.addCustomer(mockedCustomer)).thenReturn(mockedCustomer);
		Customer customer = underTest.addCustomer(mockedCustomer);
		assertEquals(mockedCustomer, customer);
	}

	@Test
	public void getCustomerById() throws Exception {
		when(mockedCustomerRepository.getCustomerById("1234")).thenReturn(mockedCustomer);
		Customer customer = underTest.getCustomerById("1234");
		assertEquals(mockedCustomer,customer);
	}
}
