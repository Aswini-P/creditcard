package com.cg.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.entity.Account;
import com.cg.service.IAccountService;

@RestController
public class AccountController {
	@Autowired
	private IAccountService accountServ;
	@PostMapping("/accounts")
	public ResponseEntity<Account> addAccount(@Valid @RequestBody Account a) {
		return new ResponseEntity<>(accountServ.addAccount(a), HttpStatus.CREATED);
		}
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<Account> removeAccount(@PathVariable("id")long id){
		return new ResponseEntity<>(accountServ.removeAccount(id), HttpStatus.ACCEPTED);
		}@GetMapping("/accounts/{id}")
		public ResponseEntity<Account> getAccountById(@PathVariable("id")long id){
			return new ResponseEntity<>(accountServ.getAccount(id), HttpStatus.FOUND);
			}@GetMapping("/accounts")
			public ResponseEntity<List<Account>>getAccounts(){
				return new ResponseEntity<>(accountServ.getAllAccounts(), HttpStatus.FOUND);
				}@PutMapping("/accounts/{id}")
				public ResponseEntity<Account>updateAccountById(@PathVariable long id,@Valid @RequestBody Account a){
					return new ResponseEntity<>(accountServ.updateAccount(id, a), HttpStatus.ACCEPTED);
					}
}