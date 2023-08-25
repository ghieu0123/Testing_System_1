package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Account;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AccountController {
	@Autowired
	IAccountService service;
	
	@GetMapping()
	public List<Account> getAllAccount(){
		return service.getAllAccounts();
	}
	
	@GetMapping(value = "/{id}")
	public Account getAccountById(@PathVariable(name = "id") int id) {
		return service.getAccountByID(id);
	}
	
	@PostMapping()
	public void createAccount(@RequestBody Account account) {
		service.createAccount(account);
	}
	
	@PutMapping(value = "/{id}")
	public void updateAccount(@PathVariable(name = "id") int id, @RequestBody Account account) {
		account.setAccountId((short) id);
		service.updateAccount(account);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteAccount(@PathVariable(name = "id") int id){
		service.deleteAccount(id);
	}
}
