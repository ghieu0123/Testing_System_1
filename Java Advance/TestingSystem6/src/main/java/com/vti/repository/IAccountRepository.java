package com.vti.repository;

import java.util.List;

import com.vti.entity.Account;

public interface IAccountRepository {

	public List<Account> getAllAccounts();

	public Account getAccountByID(int id);

	public Account getAccountByName(String name);

	public void createAccount(Account account);

	public void updateAccount(int id, String email, String userName, String fullName, String password, String confirmPassword, String phone);

	public void updateAccount(Account account);

	public void deleteAccount(int id);

	public boolean isAccountExistsByID(int id);

	public boolean isAccountExistsByName(String userName);

}
