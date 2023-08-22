package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

public class AccountRepository {

	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {

		Session session = null;
		List<Account> list = new ArrayList<Account>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Account>) session.createQuery("FROM Account").list();

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

	public Account getAccountByID(short id) {

		Session session = null;
		Account account = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Account by id
			account = session.get(Account.class, id);

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
		return account;
	}

	@SuppressWarnings("unchecked")
	public Account getAccountByName(String name) {

		Session session = null;
		Account account = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE account_name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			account = query.uniqueResult();

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
		return account;
	}

	public void createAccount(Account account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(account);
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

	public void updateAccount(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Account
			Account account = (Account) session.load(Account.class, id);

			// update
			account.setFirstName(newName);

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

	public void updateAccount(Account account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(account);
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

	public void deleteAccount(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Account
			Account account = (Account) session.load(Account.class, id);

			// delete
			session.delete(account);
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

	public boolean isAccountExistsByID(short id) {

		// get Account
		Account account = getAccountByID(id);

		// return result
		if (account == null) {
			return false;
		}

		return true;
	}

	public boolean isAccountExistsByName(String name) {
		Account account = getAccountByName(name);

		if (account == null) {
			return false;
		}
		return true;
	}

}
