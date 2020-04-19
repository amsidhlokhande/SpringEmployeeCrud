package com.amsidh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "EMPID")
	private Integer empId;
	@Column(name = "EMPNAME")
	private String name;
	@Column(name = "EMPAGE")
	private Integer age;
	@Column(name = "SALARY")
	private Integer salary;
	@Column(name = "ADDRESS")
	private String address;

	public Employee() {

	}

	public Employee(Integer empId, String name, Integer age, Integer salary,
			String address) {
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.address = address;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
