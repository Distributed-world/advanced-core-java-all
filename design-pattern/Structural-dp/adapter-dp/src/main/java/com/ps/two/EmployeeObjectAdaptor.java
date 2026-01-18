package com.ps.two;

public class EmployeeObjectAdaptor implements Customer {
	private Employee employee;

	public EmployeeObjectAdaptor(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public String getName() {
		return employee.getFullName();
	}

	@Override
	public String getDesignation() {
		return employee.getJobTitle();
	}

	@Override
	public String getAddress() {
		return employee.getOfficeLocation();
	}

}
