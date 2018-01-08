package com.app.bankapp.model;

import java.io.Serializable;

import com.app.bankapp.vo.CustomerVO;

public class Customer implements Serializable {

	private static final long serialVersionUID = 79312971223636957L;
	private String firstName;
	private String lastName;
	private String id;
	private String zipCode;
	private String email;
	private String ssnLast4;
	
	public Customer() {
		
	}
	
	public Customer(CustomerVO customerVO) {
		if(customerVO == null) {
			return;
		}
		String id = customerVO.getZipCode() + customerVO.getSsnLast4();
		this.firstName = customerVO.getFirstName();
		this.lastName = customerVO.getLastName();
		this.id = id;
		this.zipCode = customerVO.getZipCode();
		this.email = customerVO.getEmail();
		this.ssnLast4 = customerVO.getSsnLast4();
	}
	
	public Customer(Customer cust) {
		if(cust == null) {
			return;
		}
		this.firstName = cust.firstName;
		this.lastName = cust.lastName;
		this.id = cust.id;
		this.zipCode = cust.zipCode;
		this.email = cust.email;
		this.ssnLast4 = cust.ssnLast4;
	}
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSsnLast4() {
		return ssnLast4;
	}
	public void setSsnLast4(String ssnLast4) {
		this.ssnLast4 = ssnLast4;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", zipCode=" + zipCode
				+ ", email=" + email + "]";
	}
	
	
}
