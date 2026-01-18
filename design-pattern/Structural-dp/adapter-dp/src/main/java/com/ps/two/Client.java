package com.ps.two;

public class Client {

	public static void main(String[] args) {
		/*       class/two way adaptor*/
		EmployeeClassAdaptor employeeClassAdaptor = new EmployeeClassAdaptor();
		initializeEmpData(employeeClassAdaptor);
		BussinessCardDesigner bussinessCardDesigner = new BussinessCardDesigner();
		System.out.println(bussinessCardDesigner.designCard(employeeClassAdaptor));
		/*       object adaptor*/
		Employee employee = new Employee();
		initializeEmpData(employee);
		EmployeeObjectAdaptor employeeObjectAdaptor = new EmployeeObjectAdaptor(employee);
		System.out.println(bussinessCardDesigner.designCard(employeeObjectAdaptor));
	}

	private static void initializeEmpData(Employee employee) {
		employee.setFullName("Prem Prakash Rohan");
		employee.setJobTitle("SSE");
		employee.setOfficeLocation("Bangalore");
		
	}

}
