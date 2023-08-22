package com.vti.frontend;

import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Position;
import com.vti.repository.PositionRepository;

public class PositionProgram {
	public static void main(String[] args) {
		PositionRepository repository = new PositionRepository();

//		System.out.println("\n\n***********CREATE POSITION***********");
//
//		Position positionCre = new Position();
//		positionCre.setPositionName(Position.PositionName.PM);
//		repository.createPosition(positionCre);

		System.out.println("***********GET ALL POSITIONS***********");

		List<Position> positions = repository.getAllPositions();

		for (Position position : positions) {
			System.out.println(position.getPositionName().getName());
			for (Account account : position.getAccounts()) {
				System.out.println(account.getFullName());
			}
			System.out.println();
		}

	}
}
