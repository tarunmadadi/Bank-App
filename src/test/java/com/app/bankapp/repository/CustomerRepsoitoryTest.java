package com.app.bankapp.repository;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;

import java.util.ArrayList;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.app.bankapp.dataStore.DataStore;
import com.app.bankapp.delegate.RestDelegate;
import com.app.bankapp.delegate.model.Person;
import com.app.bankapp.delegate.model.PersonRequest;
import com.app.bankapp.exception.BankAppException;
import com.app.bankapp.model.Customer;

//import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DataStore.class)
public class CustomerRepsoitoryTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Mock
	private RestDelegate mockedRestDelegate;

	@InjectMocks
	private CustomerRepository underTest;

	

	@Test
	public void addCustomerFailure() {
		
		given(mockedRestDelegate.doPOST(any(PersonRequest.class), eq(Person.class))).willReturn(new Person());
		exception.expect(BankAppException.class);
		
		underTest.addCustomer(new Customer());
	}
	
	@Test
	public void addCustomerWithoutException() {
		Person person =new Person();
		person.setEligibility("ELIGIBLE");
		given(mockedRestDelegate.doPOST(any(PersonRequest.class), eq(Person.class))).willReturn(person);
		
		Customer customer = new Customer();
		PowerMockito.mockStatic(DataStore.class);
		PowerMockito.when(DataStore.add(customer)).thenReturn(customer);
		
		Customer result = underTest.addCustomer(customer);
		assertEquals(customer,result);
	}
	
	@Test
	public void getCustomerById() {
		PowerMockito.mockStatic(DataStore.class);
		PowerMockito.when(DataStore.getCustomerList()).thenReturn(new ArrayList<Customer>());
		
		Customer result = underTest.getCustomerById("1234");
		assertEquals(null,result);
	}
}
