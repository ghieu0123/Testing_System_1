package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Answer;
import com.vti.utils.HibernateUtils;

public class AnswerRepository {

	private HibernateUtils hibernateUtils;

	public AnswerRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Answer> getAllAnswers() {

		Session session = null;
		List<Answer> list = new ArrayList<Answer>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Answer>) session.createQuery("FROM Answer").list();

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

	public Answer getAnswerByID(short id) {

		Session session = null;
		Answer answer = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get answer by id
			answer = session.get(Answer.class, id);

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
		return answer;
	}

	@SuppressWarnings("unchecked")
	public Answer getAnswerByName(String name) {

		Session session = null;
		Answer answer = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<Answer> query = session.createQuery("FROM Answer WHERE answer_name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			answer = query.uniqueResult();

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
		return answer;
	}

	public void createAnswer(Answer answer) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(answer);
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

	public void updateAnswer(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get answer
			Answer answer = (Answer) session.load(Answer.class, id);

			// update
			answer.setContent(newName);

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

	public void updateAnswer(Answer answer) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(answer);
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

	public void deleteAnswer(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get answer
			Answer answer = (Answer) session.load(Answer.class, id);

			// delete
			session.delete(answer);
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

	public boolean isAnswerExistsByID(short id) {

		// get answer
		Answer answer = getAnswerByID(id);

		// return result
		if (answer == null) {
			return false;
		}

		return true;
	}

	public boolean isAnswerExistsByName(String name) {
		Answer answer = getAnswerByName(name);

		if (answer == null) {
			return false;
		}
		return true;
	}

}
