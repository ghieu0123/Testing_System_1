package com.vti.frontend;

import java.util.List;

import com.vti.entity.DetailDepartment;
import com.vti.repository.DetailDepartmentRepository;

public class DetailDepartmentProgram {
	public static void main(String[] args) {
		DetailDepartmentRepository repository = new DetailDepartmentRepository();

		System.out.println("***********GET ALL DETAIL DEPARTMENT***********");

		List<DetailDepartment> detailDepartmentList = repository.getAllDetailDepartments();

		for (DetailDepartment department : detailDepartmentList) {
			System.out.println(department);
		}

	}
}
