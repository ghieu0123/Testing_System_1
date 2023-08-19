package com.vti.frontend;

import java.util.List;

import com.vti.entity.CategoryQuestion;
import com.vti.repository.CategoryQuestionRepository;

public class CategoryQuestionProgram {
	public static void main(String[] args) {
		CategoryQuestionRepository repository = new CategoryQuestionRepository();

		System.out.println("\n\n***********CREATE CATEGORY QUESTION***********");

		CategoryQuestion categoryQuestionCre = new CategoryQuestion();
		categoryQuestionCre.setCategoryName("Category Question test 1");
		repository.createCategoryQuestion(categoryQuestionCre);

		System.out.println("***********GET ALL  CATEGORY QUESTION***********");

		List<CategoryQuestion> categoryQuestions = repository.getAllCategoryQuestions();

		for (CategoryQuestion categoryQuestion : categoryQuestions) {
			System.out.println(categoryQuestion);
		}

	}
}
