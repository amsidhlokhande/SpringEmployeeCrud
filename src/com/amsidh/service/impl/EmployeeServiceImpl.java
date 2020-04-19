package com.amsidh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amsidh.dao.EmployeeDao;
import com.amsidh.domain.Employee;
import com.amsidh.service.EmployeeService;
@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)  
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);

	}

	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);

	}

	public Employee getEmployee(int empId) {
		return employeeDao.getEmployee(empId);
	}

	public List<Employee> listEmployeess() {
		
		return employeeDao.listEmployeess();
	}

}
