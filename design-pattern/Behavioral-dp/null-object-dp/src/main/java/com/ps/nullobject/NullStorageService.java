package com.ps.nullobject;

public class NullStorageService implements Service {

	@Override
	public void save(Report report) {
		System.out.println("Null object save method. Doing nothing");
	}

	
}
