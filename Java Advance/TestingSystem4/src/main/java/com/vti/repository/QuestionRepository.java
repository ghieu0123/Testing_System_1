package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Question;
import com.vti.utils.HibernateUtils;

public class QuestionRepository {

	private HibernateUtils hibernateUtils;

	public QuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestions() {

		Session session = null;
		List<Question> list = new ArrayList<Question>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Question>) session.createQuery("FROM Question").list();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public Question getQuestionByID(short id) {

		Session session = null;
		Question question = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get question by id
			question = session.get(Question.class, id);

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return question;
	}

	@SuppressWarnings("unchecked")
	public Question getQuestionByName(String name) {

		Session session = null;
		Question question = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<Question> query = session.createQuery("FROM Question WHERE question_name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			question = query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return question;
	}

	public void createQuestion(Question question) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(question);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateQuestion(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get question
			Question question = (Question) session.load(Question.class, id);

			// update
			question.setContent(newName);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateQuestion(Question question) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(question);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteQuestion(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get question
			Question question = (Question) session.load(Question.class, id);

			// delete
			session.delete(question);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isQuestionExistsByID(short id) {

		// get question
		Question question = getQuestionByID(id);

		// return result
		if (question == null) {
			return false;
		}

		return true;
	}

	public boolean isQuestionExistsByName(String name) {
		Question question = getQuestionByName(name);

		if (question == null) {
			return false;
		}
		return true;
	}

}
