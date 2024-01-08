package com.ps.nullobject2;

public class CoderEmployee extends Employee {
	public CoderEmployee(String name) 
    {
        this.name = name;
    }

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isNull() {
		return false;
	}
}
