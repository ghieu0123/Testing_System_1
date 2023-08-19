package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.CategoryQuestion;
import com.vti.utils.HibernateUtils;

public class CategoryQuestionRepository {

	private HibernateUtils hibernateUtils;

	public CategoryQuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<CategoryQuestion> getAllCategoryQuestions() {

		Session session = null;
		List<CategoryQuestion> list = new ArrayList<CategoryQuestion>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<CategoryQuestion>) session.createQuery("FROM CategoryQuestion").list();

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

	public CategoryQuestion getCategoryQuestionByID(short id) {

		Session session = null;
		CategoryQuestion categoryQuestion = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get categoryQuestion by id
			categoryQuestion = session.get(CategoryQuestion.class, id);

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
		return categoryQuestion;
	}

	@SuppressWarnings("unchecked")
	public CategoryQuestion getCategoryQuestionByName(String name) {

		Session session = null;
		CategoryQuestion categoryQuestion = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion WHERE category_name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			categoryQuestion = query.uniqueResult();

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
		return categoryQuestion;
	}

	public void createCategoryQuestion(CategoryQuestion categoryQuestion) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(categoryQuestion);
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

	public void updateCategoryQuestion(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get categoryQuestion
			CategoryQuestion categoryQuestion = (CategoryQuestion) session.load(CategoryQuestion.class, id);

			// update
			categoryQuestion.setCategoryName(newName);

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

	public void updateCategoryQuestion(CategoryQuestion categoryQuestion) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(categoryQuestion);
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

	public void deleteCategoryQuestion(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get categoryQuestion
			CategoryQuestion categoryQuestion = (CategoryQuestion) session.load(CategoryQuestion.class, id);

			// delete
			session.delete(categoryQuestion);
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

	public boolean isCategoryQuestionExistsByID(short id) {

		// get categoryQuestion
		CategoryQuestion categoryQuestion = getCategoryQuestionByID(id);

		// return result
		if (categoryQuestion == null) {
			return false;
		}

		return true;
	}

	public boolean isCategoryQuestionExistsByName(String name) {
		CategoryQuestion categoryQuestion = getCategoryQuestionByName(name);

		if (categoryQuestion == null) {
			return false;
		}
		return true;
	}

}
