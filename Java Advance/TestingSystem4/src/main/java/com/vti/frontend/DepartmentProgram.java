package com.vti.frontend;

import java.util.List;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class DepartmentProgram {
	public static void main(String[] args) {
		DepartmentRepository repository = new DepartmentRepository();
		// Ex1
//		testCRUD(repository);

		// Ex2
		getAllDepartments(repository);
//		getTotalCount(repository);
//		getDepartmentByID(repository);
//		getDepartmentByName(repository);
//		updateDepartment(repository);
//		deleteDepartment(repository);
//		checkDepartmentById(repository);
//		checkDepartmentByName(repository);

	}

	public static void getAllDepartments(DepartmentRepository repository) {
		System.out.println("***********GET ALL DEPARTMENT***********");

		List<DepartmentDTO> departmentDtoList = repository.getAllDepartmentsUsingConstructor(1, 10, "t", (short) 2);

		for (DepartmentDTO department : departmentDtoList) {
			System.out.println(department);
			System.out.println();
		}
	}

	public static void getTotalCount(DepartmentRepository repository) {
		System.out.println("***********GET TOTAL COUNT***********");
		Long totalCnt = repository.getTotalCount(null, (short) 2);
		System.out.println(totalCnt);
	}

	public static void getDepartmentByID(DepartmentRepository repository) {
		System.out.println("***********GET DEPARTMENT BY ID***********");
		Department department = repository.getDepartmentByID((short) 2);
		System.out.println(department);
	}

	public static void getDepartmentByName(DepartmentRepository repository) {
		System.out.println("***********GET DEPARTMENT BY NAME***********");
		Department department = repository.getDepartmentByName("Sale");
		System.out.println(department);
	}

	public static void updateDepartment(DepartmentRepository repository) {
		System.out.println("***********UPDATE DEPARTMENT***********");
		Department department = repository.getDepartmentByID((short) 2);
		System.out.println("befor: " + department);
		repository.updateDepartment((short) 2, "test update 2", (short) 3, (short) 3);
		Department department2 = repository.getDepartmentByID((short) 2);
		System.out.println("after: " + department2);
	}

	public static void deleteDepartment(DepartmentRepository repository) {
		getAllDepartments(repository);
		System.out.println("***********DELETE DEPARTMENT***********");
		repository.deleteDepartment((short) 3);
		getAllDepartments(repository);
	}

	public static void checkDepartmentById(DepartmentRepository repository) {
		System.out.println("***********CHECK DEPARTMENT BY ID***********");
		System.out.println(repository.isDepartmentExistsByID((short) 2));
	}

	public static void checkDepartmentByName(DepartmentRepository repository) {
		System.out.println("***********CHECK DEPARTMENT BY NAME***********");
		System.out.println(repository.isDepartmentExistsByName("Sale"));
	}

	public static void testCRUD(DepartmentRepository repository) {
		System.out.println("\n\n***********CREATE DEPARTMENT***********");

		Department departmentCre = new Department();
		departmentCre.setDepartmentName("department test 2");
		repository.createDepartment(departmentCre);

		System.out.println("***********GET ALL DEPARTMENT***********");

		List<Department> departmentList = repository.getAllDepartments();

		for (Department department : departmentList) {
			System.out.println(department);
			for (Account account : department.getAccounts()) {
				System.out.println(account.getFullName());
			}
			System.out.println();
		}
	}
}
