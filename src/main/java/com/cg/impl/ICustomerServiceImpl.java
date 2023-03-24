package com.cg.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.exceptions.CustomerNotFoundException;
import com.cg.exceptions.UserAlreadyExistException;
import com.cg.exceptions.UserIdNotFoundException;
import com.cg.repository.ICustomerRepository;
import com.cg.service.ICustomerService;

@Service
public class ICustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerRepository customerRepository;

	public Customer addCustomer(Customer c) {
		Customer existingCustomer =customerRepository.findByUserId(c.getUserId());
		if (existingCustomer != null) 
		{
			throw new UserAlreadyExistException("User already Registred/exists, sign in ");
			}
		c.setPassword(c.getPassword()); 
		customerRepository.save(c);return c;
	}

	public Customer removeCustomer(long id) 
		{
			Customer c = customerRepository.removeCustomer(id);
			if (c != null) 
			{
				customerRepository.deleteById(id);
				return c;
				} else 
				{
					throw new UserIdNotFoundException("No user present");
					}
			}

	public Customer updateCustomer(long id, Customer c) 
			{
				Optional<Customer> customerOp = customerRepository.findById(id);
			if (customerOp.isPresent()) 
			{
				customerRepository.updateCustomer(id, c);return c;
				} 
			else {
				throw new UserIdNotFoundException("User not found");
				}
			}

	public Customer getCustomer(long id) {
		if (customerRepository.existsById(id)) {
			return customerRepository.getCustomer(id);
		} else {
			throw new UserIdNotFoundException("No user found");
		}
	}
	@Override
			public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
}
