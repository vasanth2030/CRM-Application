package com.vasanth.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vasanth.project.entities.Customer;
import com.vasanth.project.utils.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers(int id) {
		
		Session session= sessionFactory.getCurrentSession();
		
		String sort=null;
		
		switch(id)
		{
		case SortUtils.FIRST_NAME:
			sort="firstName";
			break;
			
		case SortUtils.LAST_NAME:
			sort="lastName";
			break;
			
		case SortUtils.EMAIL:
			sort="email";
			break;
			
		default:
			sort="lastName";
		}
		
		Query<Customer> theQuery=session.createQuery("from Customer order by "+sort,Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}
	
	public void addCustomer(Customer theCustomer)
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session session= sessionFactory.getCurrentSession();
		
		Customer customer= session.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {

		Session session= sessionFactory.getCurrentSession();
		Query<Customer> query= session.createQuery("delete from Customer where id=:customerId",Customer.class);
		query.setParameter("customerId", theId);
		query.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomer(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customers;
		
		if(name!=null && name.trim().length()>0)
		{
			Query<Customer> query=session.createQuery("from Customer where lower(firstName) like :theName "
					+ "or lower(lastName) like :theName",Customer.class);
			
			query.setParameter("theName", "%"+name+"%");
			
			customers = query.getResultList();
			
		}
		
		else
		{
			customers= session.createQuery("from Customer",Customer.class).getResultList();
		}
		
		return customers;
	}


}
