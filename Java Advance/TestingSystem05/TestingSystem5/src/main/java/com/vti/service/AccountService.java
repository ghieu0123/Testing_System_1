package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository repository;

	public List<Account> getAllAccounts() {
		return repository.getAllAccounts();
	}

	public Account getAccountByID(int id) {
		return repository.getAccountByID(id);
	}

	public Account getAccountByName(String name) {
		return repository.getAccountByName(name);
	}

	public void createAccount(Account Account) {
		repository.createAccount(Account);
	}

	public void updateAccount(int id, String email, String userName, String fullName, String password, String confirmPassword, String phone) {
		repository.updateAccount(id, email, userName, fullName, password, confirmPassword, phone);
	}

	public void updateAccount(Account account) {
		repository.updateAccount(account);
	}

	public void deleteAccount(int id) {
		repository.deleteAccount(id);
	}

	public boolean isAccountExistsByID(int id) {
		return repository.isAccountExistsByID(id);
	}

	public boolean isAccountExistsByName(String name) {
		return repository.isAccountExistsByName(name);
	}
}
