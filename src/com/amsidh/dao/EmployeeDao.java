package com.amsidh.dao;

import java.util.List;


import com.amsidh.domain.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();

	public Employee getEmployee(int empId);

	public void deleteEmployee(Employee employee);
	
}
