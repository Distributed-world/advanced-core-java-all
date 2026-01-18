package com.ps.two;

public class BussinessCardDesigner {
	public String designCard(Customer customer) {
		return "" + customer.getName() + "\n" + customer.getDesignation() + "\n" + customer.getAddress();
	}
}