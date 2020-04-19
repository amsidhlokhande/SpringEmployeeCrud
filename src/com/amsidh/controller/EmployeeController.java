package com.amsidh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amsidh.bean.EmployeeBean;
import com.amsidh.domain.Employee;
import com.amsidh.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welCome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(
			@ModelAttribute(value = "command") EmployeeBean employeeBean,
			BindingResult result) {
		Employee employee = prepareModel(employeeBean);
		employeeService.addEmployee(employee);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", prepareListofBean(employeeService
				.listEmployeess()));
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addEmployee(
			@ModelAttribute(value = "command") EmployeeBean employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", prepareListofBean(employeeService
				.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(
			@ModelAttribute(value = "command") EmployeeBean employeeBean,
			BindingResult result) {
		employeeService.deleteEmployee(prepareModel(employeeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees", prepareListofBean(employeeService
				.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(
			@ModelAttribute("command") EmployeeBean employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareEmployeeBean(employeeService
				.getEmployee(employeeBean.getEmpId())));
		model.put("employees", prepareListofBean(employeeService
				.listEmployeess()));
		return new ModelAndView("addEmployee", model);

	}

	public Employee prepareModel(EmployeeBean employeeBean) {
		Employee employee = new Employee();
		employee.setEmpId(employeeBean.getEmpId());
		employee.setName(employeeBean.getName());
		employee.setAge(employeeBean.getAge());
		employee.setSalary(employeeBean.getSalary());
		employee.setAddress(employeeBean.getAddress());
		return employee;
	}

	public List<EmployeeBean> prepareListofBean(List<Employee> employeeList) {
		List<EmployeeBean> employeeBeanList = new ArrayList<EmployeeBean>();
		for (Employee employee : employeeList) {
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmpId(employee.getEmpId());
			employeeBean.setAge(employee.getAge());
			employeeBean.setAddress(employee.getAddress());
			employeeBean.setName(employee.getName());
			employeeBean.setSalary(employee.getSalary());
			employeeBeanList.add(employeeBean);
		}
		return employeeBeanList;
	}

	private EmployeeBean prepareEmployeeBean(Employee employee) {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setAddress(employee.getAddress());
		employeeBean.setAge(employee.getAge());
		employeeBean.setName(employee.getName());
		employeeBean.setSalary(employee.getSalary());
		employeeBean.setEmpId(employee.getEmpId());
		return employeeBean;
	}

}
