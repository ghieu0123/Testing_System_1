package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;

public class DetailDepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DetailDepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<DetailDepartment> getAllDetailDepartments() {

		Session session = null;
		List<DetailDepartment> list = new ArrayList<DetailDepartment>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<DetailDepartment>) session.createQuery("FROM DetailDepartment").list();

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

	public DetailDepartment getDetailDepartmentByID(short id) {

		Session session = null;
		DetailDepartment detaildepartment = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get DetailDepartment by id
			detaildepartment = session.get(DetailDepartment.class, id);

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
		return detaildepartment;
	}

	public void createDetailDepartment(DetailDepartment detaildepartment) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(detaildepartment);
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

	public void updateDetailDepartment(DetailDepartment detaildepartment) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(detaildepartment);
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

	public void deleteDetailDepartment(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get DetailDepartment
			DetailDepartment detaildepartment = (DetailDepartment) session.load(DetailDepartment.class, id);

			// delete
			session.delete(detaildepartment);
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

	public boolean isDetailDepartmentExistsByID(short id) {

		// get DetailDepartment
		DetailDepartment detaildepartment = getDetailDepartmentByID(id);

		// return result
		if (detaildepartment == null) {
			return false;
		}

		return true;
	}

}
