package com.vti.frontend;

import java.util.List;

import com.vti.entity.Exam;
import com.vti.repository.ExamRepository;

public class ExamProgram {
	public static void main(String[] args) {
		ExamRepository repository = new ExamRepository();

		System.out.println("\n\n***********CREATE EXAM***********");
		
		Exam examCre = new Exam();
		examCre.setTitle("Đề thi test");
		examCre.setCode1("L-1");
		repository.createExam(examCre);

		System.out.println("***********GET ALL EXAM***********");

		List<Exam> exams = repository.getAllExams();

		for (Exam exam : exams) {
			System.out.println(exam);
		}

	}
}
