package com.vti.entity;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.vti.repository.ExamRepository;

public class ExamCodeGenerator implements IdentifierGenerator {

	private ExamRepository repository;
	
	public ExamCodeGenerator() {
		repository = new ExamRepository();
	}

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String code = "";
		Exam exam = (Exam) object;

		short duration = exam.getDuration();
		int count = repository.getCountDuration(duration);

		if (duration >= 180) {
			code = "L-" + (count + 1);
		} else if (duration >= 90) {
			code = "M-" + (count + 1);
		} else {
			code = "S-" + (count + 1);
		}

		return code;
	}

}
