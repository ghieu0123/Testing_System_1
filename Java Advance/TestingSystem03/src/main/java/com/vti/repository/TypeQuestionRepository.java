package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.TypeQuestion;
import com.vti.entity.TypeQuestion.TypeName;
import com.vti.utils.HibernateUtils;

public class TypeQuestionRepository {

	private HibernateUtils hibernateUtils;

	public TypeQuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<TypeQuestion> getAllTypeQuestions() {

		Session session = null;
		List<TypeQuestion> list = new ArrayList<TypeQuestion>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<TypeQuestion>) session.createQuery("FROM TypeQuestion").list();

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

	public TypeQuestion getTypeQuestionByID(short id) {

		Session session = null;
		TypeQuestion typeQuestion = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get typeQuestion by id
			typeQuestion = session.get(TypeQuestion.class, id);

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
		return typeQuestion;
	}

	@SuppressWarnings("unchecked")
	public TypeQuestion getTypeQuestionByName(String name) {

		Session session = null;
		TypeQuestion typeQuestion = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion WHERE type_name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			typeQuestion = query.uniqueResult();

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
		return typeQuestion;
	}

	public void createTypeQuestion(TypeQuestion typeQuestion) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(typeQuestion);
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

	public void updateTypeQuestion(short id, TypeName newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get typeQuestion
			TypeQuestion typeQuestion = (TypeQuestion) session.load(TypeQuestion.class, id);

			// update
			typeQuestion.setName(newName);

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

	public void updateTypeQuestion(TypeQuestion typeQuestion) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(typeQuestion);
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

	public void deleteTypeQuestion(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get typeQuestion
			TypeQuestion typeQuestion = (TypeQuestion) session.load(TypeQuestion.class, id);

			// delete
			session.delete(typeQuestion);
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

	public boolean isTypeQuestionExistsByID(short id) {

		// get typeQuestion
		TypeQuestion typeQuestion = getTypeQuestionByID(id);

		// return result
		if (typeQuestion == null) {
			return false;
		}

		return true;
	}

	public boolean isTypeQuestionExistsByName(String name) {
		TypeQuestion typeQuestion = getTypeQuestionByName(name);

		if (typeQuestion == null) {
			return false;
		}
		return true;
	}

}
