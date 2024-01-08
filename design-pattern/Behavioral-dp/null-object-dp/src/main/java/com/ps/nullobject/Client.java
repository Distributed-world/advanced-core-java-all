package com.ps.nullobject;

public class Client {
	private static Service isAuthorized(String action) {
		if(action.contains("2")) {
			return new NullStorageService();
		}else {
			return new StorageService();
		}
	}
	public static void main(String[] args) {
		ComplexService service = new ComplexService("Simple report 2",isAuthorized("Simple report 2"));
		service.generateReport();
		
		service = new ComplexService("Simple report 1",isAuthorized("Simple report 1"));
		service.generateReport();

	}

}
