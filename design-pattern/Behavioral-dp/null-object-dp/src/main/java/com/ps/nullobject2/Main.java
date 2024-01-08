package com.ps.nullobject2;

public class Main {
	public static void main(String[] args) {
		Employee emp1 = EmpData.getClient("Lokesh");
		Employee emp2 = EmpData.getClient("Kushagra");
		Employee emp3 = EmpData.getClient("Vikram");
		Employee emp4 = EmpData.getClient("Rishabh");

		System.out.println(emp1.getName());
		System.out.println(emp2.getName());
		System.out.println(emp3.getName());
		System.out.println(emp4.getName());
	}
}