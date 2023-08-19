package com.vti.frontend;

import java.util.List;

import com.vti.entity.Employee;
import com.vti.repository.EmployeeRepository;

public class EmployeeProgram {
	public static void main(String[] args) {
		EmployeeRepository repository = new EmployeeRepository();

		System.out.println("***********GET ALL EMPLOYEE***********");

		List<Employee> employeeList = repository.getAllEmployees();

		for (Employee employee : employeeList) {
			System.out.println(employee);
		}

	}
}
