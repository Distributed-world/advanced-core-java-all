package com.ps.nullobject;

public class ComplexService {

	private Service storage;
	
	private String reportName;
	
	public ComplexService(Service storage) {
		this.storage = storage;
		reportName = "A Complex Report";
	}
	
	public ComplexService(String reportName, Service storage) {
		this.storage = storage;
		this.reportName = reportName;
	}
	
	public void generateReport() {
		System.out.println("Starting a complex report build!");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Done with report..");
		storage.save(new Report(reportName));
	}
}
