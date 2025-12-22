package com.ibm.collection;


public class Employee {
	private String firstName,lastName,department;
	private double salaryPackage;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalaryPackage() {
		return salaryPackage;
	}
	public void setSalaryPackage(double salaryPackage) {
		this.salaryPackage = salaryPackage;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
