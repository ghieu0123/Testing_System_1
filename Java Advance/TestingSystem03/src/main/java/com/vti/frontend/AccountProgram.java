package com.vti.frontend;

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

public class AccountProgram {
	public static void main(String[] args) {
		AccountRepository repository = new AccountRepository();

//		System.out.println("\n\n***********CREATE ACCOUNT***********");
//
//		Account accountCre = new Account();
//		accountCre.setEmail("nguyenan@gmail.com");
//		accountCre.setUsername("annguyen");
//		accountCre.setFirstName("An");
//		accountCre.setLastName("nguyen");
//		repository.createAccount(accountCre);

		System.out.println("***********GET ALL ACCOUNT***********");

		List<Account> accounts = repository.getAllAccounts();

		for (Account account : accounts) {
			String workingNumberOfYear = account.getEmployee() != null ? String.valueOf(account.getEmployee().getWorkingNumberOfYear()) : "";
			String managementNumberOfYear = account.getManager() != null ? String.valueOf(account.getManager().getManagementNumberOfYear()) : "";
			
			System.out.println(account.getFullName());
			System.out.println(account.getUsername());
			System.out.println(account.getEmail());
			System.out.println(account.getDepartment().getDepartmentName());
			System.out.println(account.getPosition().getPositionName());
			System.out.println(account.getSalary().getName().getSalaryName());
			System.out.println("workingNumberOfYear: " + workingNumberOfYear);
			System.out.println("managementNumberOfYear: " + managementNumberOfYear);
			System.out.println();
		}

	}
}
