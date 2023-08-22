package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mysql.cj.util.StringUtils;
import com.vti.dto.DepartmentDTO;
import com.vti.entity.Address;
import com.vti.entity.Department;
import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;

public class DepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	// a. createDepartments()
	public void createDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);
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

	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments() {

		Session session = null;
		List<Department> list = new ArrayList<Department>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Department>) session.createQuery("FROM Department").list();

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

//		b. getAllDepartments()
//		Chú ý: Chỉ viết 1 method và thực hiện được các yêu cầu dưới đây:
//			o Method sẽ return ra object departmentDTO chỉ chứa 3 field: id,
//			name, address của department
//			o Có 1 thể sort được theo field name
//			o Có tham số pageNumber và pageSize để cho phép người dùng
//			có thể paging
//			o Có thể search theo field name
//			o Có thể Filter cho phép người dùng nhập vào 1 số dương và kết
//			quả trả ra là các record department có EmulationPoints lớn hơn
//			số người dùng nhập vào
	@SuppressWarnings("unchecked")
	public List<DepartmentDTO> getAllDepartmentsUsingConstructor(int pageNum, int pageSize, String departmentName,
			Short emulationPoint) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			int offset = (pageNum - 1) * pageSize;

			String hql = "SELECT new com.vti.dto.DepartmentDTO(d.departmentId, d.departmentName, d.address.addressName) FROM DetailDepartment d WHERE 1 = 1 ";

			// search by name
			if (!StringUtils.isNullOrEmpty(departmentName)) {
				hql += " AND departmentName LIKE :departmentName";
			}

			// Filter
			if (emulationPoint != null) {
				hql += " AND emulationPoint > :emulationPoint";
			}

			// sort by name
			hql += " ORDER BY d.departmentName ASC";

			// create hql query
			Query<DepartmentDTO> query = session.createQuery(hql);

			query.setFirstResult(offset);
			query.setMaxResults(pageSize);

			// search by name
			if (!StringUtils.isNullOrEmpty(departmentName)) {
				query.setParameter("departmentName", "%" + departmentName + "%");
			}

			// Filter
			if (emulationPoint != null) {
				query.setParameter("emulationPoint", emulationPoint);
			}

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	c. getTotalCount()
//	Trả về tổng số bản ghi của Department
//	Chú ý: tương tự câu b, có thể truyền vào search theo field name và
//	Filter EmulationPoints
	@SuppressWarnings("unchecked")
	public Long getTotalCount(String departmentName, Short emulationPoint) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			String hql = "SELECT COUNT(*) FROM DetailDepartment d WHERE 1 = 1 ";

			// search by name
			if (!StringUtils.isNullOrEmpty(departmentName)) {
				hql += " AND departmentName LIKE :departmentName";
			}

			// Filter
			if (emulationPoint != null) {
				hql += " AND emulationPoint > :emulationPoint";
			}

			// sort by name
			hql += " ORDER BY d.departmentName ASC";

			// create hql query
			Query<Long> query = session.createQuery(hql);

			// search by name
			if (!StringUtils.isNullOrEmpty(departmentName)) {
				query.setParameter("departmentName", "%" + departmentName + "%");
			}

			// Filter
			if (emulationPoint != null) {
				query.setParameter("emulationPoint", emulationPoint);
			}

			return query.uniqueResult();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	d. getDepartmentByID()
//	tương tự với câu b nhưng không cần sort, paging
	public Department getDepartmentByID(short id) {

		Session session = null;
		Department department = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get Department by id
			department = session.get(Department.class, id);

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
		return department;
	}

	// e. getDepartmentByName()
	@SuppressWarnings("unchecked")
	public Department getDepartmentByName(String name) {

		Session session = null;
		Department department = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE department_name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			department = query.uniqueResult();

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
		return department;
	}

//	f. updateDepartment()
//	Chú ý: sử dụng transaction, cho phép update được cả address,
//	EmulationPoints
	public void updateDepartment(short departmentId, String departmentName, Short addressId, Short emulationPoint) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			String hql = "UPDATE DetailDepartment"
					+ " SET departmentName = :departmentName"
					+ " , emulationPoint = :emulationPoint"
					+ " , address = :address"
					+ " WHERE departmentId = :departmentId";

			// create hql query 
			Query query = session.createQuery(hql);

			// set param
			query.setParameter("departmentName", departmentName);
			query.setParameter("emulationPoint", emulationPoint);
			query.setParameter("address", new Address(addressId, "P503"));
			query.setParameter("departmentId", departmentId);
			
			int result = query.executeUpdate();

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

//	g. deleteDepartment()
//	Có thể delete 1 department hoặc nhiều department theo ID
//	Chú ý: sử dụng transaction
	public void deleteDepartment(short departmentId) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			String hql = "DELETE FROM DetailDepartment"
					+ " WHERE departmentId = :departmentId";

			// create hql query 
			Query query = session.createQuery(hql);

			// set param
			query.setParameter("departmentId", departmentId);
			
			int result = query.executeUpdate();
			
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

//	h. isDepartmentExistsByID()
	public boolean isDepartmentExistsByID(short id) {

		// get Department
		Department department = getDepartmentByID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}

//	i. isDepartmentExistsByName()
	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}

}
