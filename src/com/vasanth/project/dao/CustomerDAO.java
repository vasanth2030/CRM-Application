package com.vasanth.project.dao;

import java.util.List;

import com.vasanth.project.entities.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers(int id);
	
	public void addCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomer(String name);


}
