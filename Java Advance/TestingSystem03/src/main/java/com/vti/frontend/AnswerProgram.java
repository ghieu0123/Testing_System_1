package com.vti.frontend;

import java.util.List;

import com.vti.entity.Answer;
import com.vti.repository.AnswerRepository;

public class AnswerProgram {
	public static void main(String[] args) {
		AnswerRepository repository = new AnswerRepository();

		System.out.println("\n\n***********CREATE ANSWER***********");
		
		Answer answerCre = new Answer();
		answerCre.setContent("Trả lời test");
		answerCre.setIsCorrect(true);
		repository.createAnswer(answerCre);

		System.out.println("***********GET ALL ANSWER***********");

		List<Answer> answers = repository.getAllAnswers();

		for (Answer answer : answers) {
			System.out.println(answer);
		}

	}
}
