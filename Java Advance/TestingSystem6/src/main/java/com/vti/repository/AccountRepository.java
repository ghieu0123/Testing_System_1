package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

@Repository
public class AccountRepository implements IAccountRepository {

	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {

		Session session = null;

		try {
			session = hibernateUtils.openSession();
			
			Query<Account> query = session.createQuery("FROM Account ORDER BY accountId");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account getAccountByID(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get Account by id
			Account Account = session.get(Account.class, id);

			return Account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Account getAccountByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Account Account = query.uniqueResult();

			return Account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAccount(Account Account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(Account);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAccount(Account Account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(Account);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteAccount(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Account
			Account Account = (Account) session.load(Account.class, id);

			// delete
			session.delete(Account);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAccountExistsByID(int id) {

		// get Account
		Account Account = getAccountByID(id);

		// return result
		if (Account == null) {
			return false;
		}

		return true;
	}

	public boolean isAccountExistsByName(String name) {
		Account Account = getAccountByName(name);

		if (Account == null) {
			return false;
		}
		return true;
	}

	@Override
	public void updateAccount(int id, String email, String userName, String fullName, String password, String confirmPassword,
			String phone) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Account
			Account Account = (Account) session.load(Account.class, id);

			// update
			Account.setEmail(email);
			Account.setFullName(fullName);
			Account.setPassword(password);
			Account.setConfirmPassword(confirmPassword);
			Account.setPhone(phone);


			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
