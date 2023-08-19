package com.vti.frontend;

import java.util.List;

import com.vti.entity.TypeQuestion;
import com.vti.repository.TypeQuestionRepository;

public class TypeQuestionProgram {
	public static void main(String[] args) {
		TypeQuestionRepository repository = new TypeQuestionRepository();

		System.out.println("\n\n***********CREATE TYPE QUESTION***********");

		TypeQuestion typeQuestionCre = new TypeQuestion();
		typeQuestionCre.setName(TypeQuestion.TypeName.MULTIPLE_CHOICE);
		repository.createTypeQuestion(typeQuestionCre);

		System.out.println("***********GET ALL TYPE QUESTIONS***********");

		List<TypeQuestion> typeQuestions = repository.getAllTypeQuestions();

		for (TypeQuestion typeQuestion : typeQuestions) {
			System.out.println(typeQuestion);
		}

	}
}
