package com.app.bankapp.controller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import com.app.bankapp.bo.CustomerBO;
import com.app.bankapp.exception.BankAppException;
import com.app.bankapp.model.Customer;
import com.app.bankapp.vo.CustomerVO;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRestControllerTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@InjectMocks
	private CustomerRestController underTest;

	@Mock
	private CustomerBO customerBO;

	@Mock
	private CustomerVO customerVO;
	
	@Mock
	private Customer customer;

	@Test
	public void addCustomerSuccessfully() {

		when(customerBO.addCustomer(any(Customer.class))).thenReturn(customer);
		
		ResponseEntity responseEntity = underTest.addCustomer(customerVO);
		assertNotNull(responseEntity);
	}

	@Test
	public void addCustomerFailure() {

		when(customerBO.addCustomer(any(Customer.class))).thenReturn(null);
		exception.expect(BankAppException.class);
		underTest.addCustomer(customerVO);
	}
	
	@Test
	public void getCustomerSuccessfully() {

		String id = "1234";
		when(customerBO.getCustomerById(id)).thenReturn(customer);
		
		ResponseEntity responseEntity = underTest.getCustomer("1234");
		assertNotNull(responseEntity);
	}
	
	@Test
	public void getCustomerFailure() {

		String id = "1234";
		when(customerBO.getCustomerById(id)).thenReturn(null);
		
		exception.expect(BankAppException.class);
		underTest.getCustomer("1234");
	}
	
	@Test
	public void handleException() {
		
		ResponseEntity responseEntity = underTest.handleException(new BankAppException());
		assertNotNull(responseEntity);
		verifyNoMoreInteractions(customerBO);
	}
}
