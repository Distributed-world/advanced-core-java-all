package com.ps.nullobject2;

public class EmpData {

	public static final String[] names = { "Lokesh", "Kushagra", "Vikram" };

	public static Employee getClient(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equalsIgnoreCase(name)) {
				return new CoderEmployee(name);
			}
		}
		return new NullEmployee();
	}
}
