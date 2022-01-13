package com.vasanth.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vasanth.project.dao.CustomerDAO;
import com.vasanth.project.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers(int id) {
		return customerDAO.getCustomers(id);
	}

	@Override
	@Transactional
	public void addCustomer(Customer theCustomer) {
		customerDAO.addCustomer(theCustomer);

	}
	
	@Override
	@Transactional
	public Customer getCustomer(int theId)
	{
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String name) {
	
		return customerDAO.searchCustomer(name);
	}

}
