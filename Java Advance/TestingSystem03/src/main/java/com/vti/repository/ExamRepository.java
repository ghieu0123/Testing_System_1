package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Exam;
import com.vti.utils.HibernateUtils;

public class ExamRepository {

	private HibernateUtils hibernateUtils;

	public ExamRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Exam> getAllExams() {

		Session session = null;
		List<Exam> list = new ArrayList<Exam>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Exam>) session.createQuery("FROM Exam").list();

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

	public Exam getExamByID(short id) {

		Session session = null;
		Exam exam = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get exam by id
			exam = session.get(Exam.class, id);

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
		return exam;
	}

	@SuppressWarnings("unchecked")
	public Exam getExamByName(String name) {

		Session session = null;
		Exam exam = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<Exam> query = session.createQuery("FROM Exam WHERE title = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			exam = query.uniqueResult();

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
		return exam;
	}

	public void createExam(Exam exam) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(exam);
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

	public void updateExam(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get exam
			Exam exam = (Exam) session.load(Exam.class, id);

			// update
			exam.setTitle(newName);

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

	public void updateExam(Exam exam) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(exam);
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

	public void deleteExam(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get exam
			Exam exam = (Exam) session.load(Exam.class, id);

			// delete
			session.delete(exam);
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

	public boolean isExamExistsByID(short id) {

		// get exam
		Exam exam = getExamByID(id);

		// return result
		if (exam == null) {
			return false;
		}

		return true;
	}

	public boolean isExamExistsByName(String name) {
		Exam exam = getExamByName(name);

		if (exam == null) {
			return false;
		}
		return true;
	}

	@SuppressWarnings({ "unchecked" })
	public short getCountDuration(short duration) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			String sql;

			if (duration >= 180) {
				sql = "SELECT COUNT(1) FROM Exam WHERE duration >= 180";
			} else if (duration >= 90) {
				sql = "SELECT COUNT(1) FROM Exam WHERE duration >= 90 AND duration < 180";
			} else {
				sql = "SELECT COUNT(1) FROM Exam WHERE duration < 90";
			}

			// create hql query
			Query<Long> query = session.createQuery(sql);

			// get result
			return query.uniqueResult().shortValue();

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
