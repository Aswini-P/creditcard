package com.cg.service;

import java.util.List;

import com.cg.entity.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer c);
	public Customer removeCustomer(long id);
    public Customer updateCustomer(long id, Customer c);
    public Customer getCustomer(long id);
    public List<Customer> getAllCustomers();
}
