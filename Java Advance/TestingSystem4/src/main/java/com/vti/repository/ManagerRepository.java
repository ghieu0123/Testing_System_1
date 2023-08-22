package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.entity.Manager;
import com.vti.utils.HibernateUtils;

public class ManagerRepository {

	private HibernateUtils hibernateUtils;

	public ManagerRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Manager> getAllManagers() {

		Session session = null;
		List<Manager> list = new ArrayList<Manager>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Manager>) session.createQuery("FROM Manager").list();

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

	public Manager getManagerByID(short id) {

		Session session = null;
		Manager manager = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Manager by id
			manager = session.get(Manager.class, id);

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
		return manager;
	}

	public void createManager(Manager manager) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(manager);
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

	public void updateManager(Manager manager) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(manager);
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

	public void deleteManager(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Manager
			Manager manager = (Manager) session.load(Manager.class, id);

			// delete
			session.delete(manager);
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

	public boolean isManagerExistsByID(short id) {

		// get Manager
		Manager manager = getManagerByID(id);

		// return result
		if (manager == null) {
			return false;
		}

		return true;
	}

}
