package com.amsidh.main;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amsidh.dao.impl.EmployeeDaoImpl;
import com.amsidh.domain.Employee;
import com.amsidh.service.EmployeeService;

public class MainApp {
	
	@Autowired
	private EmployeeService employeeService;
	
	public void listEmployee()
	{
		
		List<Employee> empList=employeeService.listEmployeess();
		for(Employee emp:empList)
		{
			System.out.println(emp.getName());
		}
	}
   public static void main(String[] args) {
	   
	ApplicationContext context=new ClassPathXmlApplicationContext("dispatchServlet.xml");
	new EmployeeDaoImpl().setSessionFactory(context.getBean(SessionFactory.class));
	new MainApp().listEmployee();

}
public EmployeeService getEmployeeService() {
	return employeeService;
}
public void setEmployeeService(EmployeeService employeeService) {
	this.employeeService = employeeService;
}
}
