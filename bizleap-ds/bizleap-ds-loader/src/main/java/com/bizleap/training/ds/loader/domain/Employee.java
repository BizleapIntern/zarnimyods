package com.bizleap.training.ds.loader.domain;
import org.apache.commons.lang3.builder.ToStringBuilder;
public class Employee extends AbstractEntity {

	private String title;
	private int age, salary;
	private Company workForCompany;

	
	public Employee(String boId) {
		super(boId);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Company getWorkForCompany() {
		return workForCompany;
	}

	public void setWorkForCompany(Company workForCompany) {
		this.workForCompany = workForCompany;
	}
	
	public static Employee parseEmployee(String line) {
			String[] tokens=line.split(",");
			Employee employee=new Employee(tokens[0]);
			employee.setName(tokens[1]);
			employee.setAge(Integer.parseInt(tokens[2]));
			employee.setTitle(tokens[3]);
			employee.setSalary(Integer.parseInt(tokens[4]));
			employee.setEmail(tokens[5]);
			employee.setPhone(tokens[6]);
			employee.setWorkForCompany(new Company(tokens[7]));
			return employee;
	}

	public String toString() {
		return new ToStringBuilder(this)
				.appendSuper(super.toString())
				.append("title", title)
				.append("age",age)
				.append("salary",salary)
				.append("workForCompany",workForCompany.getBoId())
				.toString();
	}
}
