package com.vti.frontend;

import java.util.List;

import com.vti.entity.Address;
import com.vti.entity.DetailDepartment;
import com.vti.repository.AddressRepository;

public class AddressProgram {
	public static void main(String[] args) {
		AddressRepository repository = new AddressRepository();

		System.out.println("***********GET ALL ADDRESS***********");

		List<Address> addressList = repository.getAllAddresss();

		for (Address address : addressList) {
			System.out.println(address.getAddressName());
			for (DetailDepartment detailDepartment : address.getDetailDepartments()) {
				System.out.println(detailDepartment.getDepartment().getDepartmentName() + " - " + detailDepartment.getEmulationPoint());
			}
		}

	}
}
