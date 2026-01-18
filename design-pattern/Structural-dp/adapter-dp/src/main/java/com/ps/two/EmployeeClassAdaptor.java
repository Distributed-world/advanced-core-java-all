package com.ps.two;

public class EmployeeClassAdaptor extends Employee implements Customer {

	@Override
	public String getName() {
		return getFullName();
	}

	@Override
	public String getDesignation() {
		return super.getJobTitle();
	}

	@Override
	public String getAddress() {
		return super.getOfficeLocation();
	}

}
