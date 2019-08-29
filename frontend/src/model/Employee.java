package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.EmployeeEntity;

@ManagedBean(name = "employee")
@SessionScoped
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String surName;
	private Date dateOfBirth;

	private Employee() {
		// TODO Auto-generated method stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public EmployeeEntity getEntity() {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setDateOfBirth(dateOfBirth);
		employeeEntity.setName(name);
		employeeEntity.setSurName(surName);
		return employeeEntity;
	}

	public List<Employee> getEmployees(List<EmployeeEntity> employeeEntities) {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		for (Iterator iterator = employeeEntities.iterator(); iterator.hasNext();) {
			EmployeeEntity employeeEntity = (EmployeeEntity) iterator.next();
			
			Employee m = new Employee();
			m.setDateOfBirth(employeeEntity.getDateOfBirth());
			m.setName(employeeEntity.getName());
			m.setSurName(employeeEntity.getSurName());
			
			employees.add(m);
		}
		
		return employees;
	}
}
