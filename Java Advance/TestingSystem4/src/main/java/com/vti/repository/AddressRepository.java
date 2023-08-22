package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.entity.Address;
import com.vti.utils.HibernateUtils;

public class AddressRepository {

	private HibernateUtils hibernateUtils;

	public AddressRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAllAddresss() {

		Session session = null;
		List<Address> list = new ArrayList<Address>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Address>) session.createQuery("FROM Address").list();

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

	public Address getAddressByID(short id) {

		Session session = null;
		Address address = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Address by id
			address = session.get(Address.class, id);

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
		return address;
	}

	public void createAddress(Address address) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(address);
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

	public void updateAddress(Address address) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(address);
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

	public void deleteAddress(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Address
			Address address = (Address) session.load(Address.class, id);

			// delete
			session.delete(address);
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

	public boolean isAddressExistsByID(short id) {

		// get Address
		Address address = getAddressByID(id);

		// return result
		if (address == null) {
			return false;
		}

		return true;
	}

}
