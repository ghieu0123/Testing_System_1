package com.vti;

import com.vti.repository.GroupRepository;

public class Program {
	public static void main(String[] args) {
		GroupRepository repository = new GroupRepository();

//		System.out.println("***********GET ALL GROUP***********");
//		List<Group> groups = repository.getAllGroups();
//
//		for (Group group : groups) {
//			System.out.println(group);
//		}
//
//		System.out.println("\n\n***********GET GROUP BY ID***********");
//		Group groupById = repository.getGroupByID((short) 2);
//		System.out.println(groupById);
//
//		System.out.println("\n\n***********GET GROUP BY NAME***********");
//		Group groupByName = repository.getGroupByName("VTI Sale 02");
//		System.out.println(groupByName);

//		System.out.println("\n\n***********CREATE GROUP***********");
//		Group groupCreate = new Group();
//		groupCreate.setName("Group 05");
//		repository.createGroup(groupCreate);

//		System.out.println("\n\n***********UPDATE GROUP 1***********");
//		repository.updateGroup((short) 3, "Security");
//
//		System.out.println("\n\n***********UPDATE GROUP 2***********");
//		Group groupUpdate = new Group();
//		groupUpdate.setId((short) 4);
//		groupUpdate.setName("Security 02");
//		groupUpdate.setCreatedDate(new Date());
//		repository.updateGroup(groupUpdate);
//
//		System.out.println("\n\n***********DELETE GROUP***********");
//		repository.deleteGroup((short) 5);
//
//		System.out.println("***********CHECK GROUP EXISTS BY ID***********");
//		System.out.println(repository.isGroupExistsByID((short) 1));
//
//		System.out.println("***********CHECK GROUP EXISTS BY NAME***********");
//		System.out.println(repository.isGroupExistsByName("Security"));
	}
}
