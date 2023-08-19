package com.vti.frontend;

import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Salary;
import com.vti.repository.SalaryRepository;

public class SalaryProgram {
	public static void main(String[] args) {
		SalaryRepository repository = new SalaryRepository();

//		System.out.println("\n\n***********CREATE SALARY***********");
//
//		Salary salaryCre = new Salary();
//		salaryCre.setSalaryName(Salary.SalaryName.PM);
//		repository.createSalary(salaryCre);

		System.out.println("***********GET ALL SALARYS***********");

		List<Salary> salarys = repository.getAllSalarys();

		for (Salary salary : salarys) {
			System.out.println(salary.getName() + ": " + salary.getName().getSalaryName());
			for (Account account : salary.getAccounts()) {
				System.out.println(account.getFirstName());
			}
			System.out.println();
		}

	}
}
