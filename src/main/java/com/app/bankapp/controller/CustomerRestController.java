package com.app.bankapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bankapp.bo.CustomerBO;
import com.app.bankapp.exception.BankAppException;
import com.app.bankapp.model.Customer;
import com.app.bankapp.vo.CustomerResponse;
import com.app.bankapp.vo.CustomerVO;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	private CustomerBO customerBO;
	
	public CustomerRestController(CustomerBO customerBO) {
		this.customerBO = customerBO;
	}

	@PostMapping(value = "/add", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_FORM_URLENCODED_VALUE }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerVO customer) {
		Customer cust = new Customer(customer);
		cust = customerBO.addCustomer(cust);
		
		if(cust == null) {
			throw new BankAppException("Duplicate entry", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<>(new CustomerResponse(cust), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/get/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("id") String id) {
		Customer customer = customerBO.getCustomerById(id);
		if(customer == null) {
			throw new BankAppException("Invalid ID", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new CustomerResponse(customer), HttpStatus.OK);
	}
	
	@ExceptionHandler(BankAppException.class)
	public ResponseEntity<CustomerResponse> handleException(BankAppException e) {
		CustomerResponse res = new CustomerResponse();
		res.setMessage(e.getMessage());
		return new ResponseEntity<>(res, e.getStatus());
	}
}
