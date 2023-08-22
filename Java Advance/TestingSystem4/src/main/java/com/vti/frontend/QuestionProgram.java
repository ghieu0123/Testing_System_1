package com.vti.frontend;

import java.util.List;

import com.vti.entity.Question;
import com.vti.repository.QuestionRepository;

public class QuestionProgram {
	public static void main(String[] args) {
		QuestionRepository repository = new QuestionRepository();

		System.out.println("\n\n***********CREATE QUESTION***********");
		
		Question questionCre = new Question();
		questionCre.setContent("Câu hỏi về VB");
		repository.createQuestion(questionCre);

		System.out.println("***********GET ALL QUESTION***********");

		List<Question> questions = repository.getAllQuestions();

		for (Question question : questions) {
			System.out.println(question);
		}

	}
}
