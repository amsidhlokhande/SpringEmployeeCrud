package com.amsidh.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amsidh.dao.EmployeeDao;
import com.amsidh.domain.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(Employee employee) {
     sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee where empId="+employee.getEmpId()).executeUpdate();

	}

	public Employee getEmployee(int empId) {
		
		return (Employee)sessionFactory.getCurrentSession().load(Employee.class, empId);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployeess() {
		return (List<Employee>)sessionFactory.getCurrentSession().createCriteria("from Employee").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
