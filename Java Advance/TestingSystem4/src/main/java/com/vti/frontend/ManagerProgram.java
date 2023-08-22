package com.vti.frontend;

import java.util.List;

import com.vti.entity.Manager;
import com.vti.repository.ManagerRepository;

public class ManagerProgram {
	public static void main(String[] args) {
		ManagerRepository repository = new ManagerRepository();

		System.out.println("***********GET ALL MANAGER***********");

		List<Manager> managerList = repository.getAllManagers();

		for (Manager manager : managerList) {
			System.out.println(manager);
		}

	}
}
