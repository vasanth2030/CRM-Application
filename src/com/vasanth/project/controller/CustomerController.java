package com.vasanth.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vasanth.project.entities.Customer;
import com.vasanth.project.service.CustomerService;
import com.vasanth.project.utils.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String getCustomerList(Model model,@RequestParam(required = false)String sort)
	{
		List<Customer> customers;
		
		if(sort!=null)
		{
			int id= Integer.parseInt(sort);
			customers=customerService.getCustomers(id);
		}
		
		else
		{
			customers=customerService.getCustomers(SortUtils.LAST_NAME);
		}		
		
		model.addAttribute("customers",customers);
		
		return "customer-list";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showCustomerForm(Model model)
	{
		Customer customer = new Customer();
		
		model.addAttribute("customer",customer);
		
		return "add-customer";
	}
	
	@PostMapping("/processForm")
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		customerService.addCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model)
	{
		Customer customer=customerService.getCustomer(theId);
		
		model.addAttribute("customer",customer);
		
		return "add-customer";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)
	{
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("customerName") String name,Model model)
	{
		List<Customer> customers=customerService.searchCustomer(name);
		
		model.addAttribute("customers",customers);
		
		return "customer-list";
	}
}
