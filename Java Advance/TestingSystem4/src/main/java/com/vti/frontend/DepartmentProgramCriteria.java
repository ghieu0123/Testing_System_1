package com.vti.frontend;

import java.util.List;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.repository.DepartmentRepositoryCriteria;

public class DepartmentProgramCriteria {
	public static void main(String[] args) {
		DepartmentRepositoryCriteria repository = new DepartmentRepositoryCriteria();
		
//		getAllDepartments(repository);
		getTotalCount(repository);
//		getDepartmentByID(repository);
//		getDepartmentByName(repository);
//		updateDepartment(repository);
//		deleteDepartment(repository);
//		checkDepartmentById(repository);
//		checkDepartmentByName(repository);

	}

	public static void getAllDepartments(DepartmentRepositoryCriteria repository) {
		System.out.println("***********GET ALL DEPARTMENT***********");

		List<DepartmentDTO> departmentDtoList = repository.getAllDepartments(1, 10, "h", (short) 2);

		for (DepartmentDTO department : departmentDtoList) {
			System.out.println(department);
			System.out.println();
		}
	}

	public static void getTotalCount(DepartmentRepositoryCriteria repository) {
		System.out.println("***********GET TOTAL COUNT***********");
		Long totalCnt = repository.getTotalCount(null, (short) 2);
		System.out.println(totalCnt);
	}

	public static void getDepartmentByID(DepartmentRepositoryCriteria repository) {
		System.out.println("***********GET DEPARTMENT BY ID***********");
		Department department = repository.getDepartmentByID((short) 2);
		System.out.println(department);
	}

	public static void getDepartmentByName(DepartmentRepositoryCriteria repository) {
		System.out.println("***********GET DEPARTMENT BY NAME***********");
		Department department = repository.getDepartmentByName("Sale");
		System.out.println(department);
	}

	public static void updateDepartment(DepartmentRepositoryCriteria repository) {
		System.out.println("***********UPDATE DEPARTMENT***********");
		Department department = repository.getDepartmentByID((short) 2);
		System.out.println("befor: " + department);
		repository.updateDepartment((short) 2, "test update 2", (short) 3, (short) 3);
		Department department2 = repository.getDepartmentByID((short) 2);
		System.out.println("after: " + department2);
	}

	public static void deleteDepartment(DepartmentRepositoryCriteria repository) {
		getAllDepartments(repository);
		System.out.println("***********DELETE DEPARTMENT***********");
		repository.deleteDepartment((short) 3);
		getAllDepartments(repository);
	}

	public static void checkDepartmentById(DepartmentRepositoryCriteria repository) {
		System.out.println("***********CHECK DEPARTMENT BY ID***********");
		System.out.println(repository.isDepartmentExistsByID((short) 2));
	}

	public static void checkDepartmentByName(DepartmentRepositoryCriteria repository) {
		System.out.println("***********CHECK DEPARTMENT BY NAME***********");
		System.out.println(repository.isDepartmentExistsByName("Sale"));
	}
}
