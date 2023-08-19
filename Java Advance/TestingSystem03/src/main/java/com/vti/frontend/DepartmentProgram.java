package com.vti.frontend;

import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class DepartmentProgram {
	public static void main(String[] args) {
		DepartmentRepository repository = new DepartmentRepository();

//		System.out.println("\n\n***********CREATE DEPARTMENT***********");
//
//		Department departmentCre = new Department();
//		departmentCre.setDepartmentName("department test 2");
//		repository.createDepartment(departmentCre);

		System.out.println("***********GET ALL DEPARTMENT***********");

		List<Department> departmentList = repository.getAllDepartments();

		for (Department department : departmentList) {
			System.out.println("DepartmentName: " + department.getDepartmentName());
			String emulationPoint = String.valueOf(department.getDetailDepartment().getEmulationPoint()); // department.getDetailDepartment() != null ? String.valueOf(department.getDetailDepartment().getEmulationPoint()) : "";
			String address = department.getDetailDepartment() != null ? department.getDetailDepartment().getAddress() != null ? String.valueOf(department.getDetailDepartment().getAddress().getAddressName()) : "" : "";
			System.out.println("EmulationPoint: " + emulationPoint);
			System.out.println("Address: " + address);
			for (Account account : department.getAccounts()) {
				System.out.println("Account: " + account.getFullName());
				
			}
			System.out.println();
		}

	}
}
