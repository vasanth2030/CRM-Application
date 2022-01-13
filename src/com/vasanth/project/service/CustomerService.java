package com.vasanth.project.service;

import java.util.List;

import com.vasanth.project.entities.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers(int id);
	
	public void addCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomer(String name);

}
