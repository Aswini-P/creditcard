package com.cg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Account;
import com.cg.entity.Admin;
import com.cg.entity.CreditCard;
import com.cg.entity.Customer;
import com.cg.service.IAccountService;
import com.cg.service.IAdminService;
import com.cg.service.ICreditCardService;
import com.cg.service.ICustomerService;

@RestController
@RequestMapping("/adminapi")
public class AdminController {
	@Autowired
	IAdminService adminservice;
	@Autowired
	ICustomerService CustomerService;
	
	
	@Autowired
	ICreditCardService CreditCardService;

	
	@Autowired
	IAccountService accountservice;
	
	@PostMapping("/addadmin")
	public  Admin addAdmin(@Valid @RequestBody Admin admin)
	{
		return adminservice.addAdmin(admin);
	}
	@PostMapping("/addcustomer")
	public  Customer addCustomer(@Valid @RequestBody Customer customer)
	{
		return CustomerService.addCustomer(customer);
	}
	
	
	@PostMapping("/addaccount")
	public Account addAccount(@Valid @RequestBody Account account) 
	{
		return accountservice.addAccount(account);
	}

	@PostMapping("/addcreditcard")
	public CreditCard addCreditCard(@Valid @RequestBody CreditCard creditCard) {

		return CreditCardService.addCreditCard(creditCard);
	}


}
