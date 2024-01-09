package com.ps.cor;

import java.time.LocalDate;

import com.ps.cor.LeaveApplication.Type;

public class Client {

	public static void main(String[] args) {
		LeaveApplication application = LeaveApplication.getBuilder().withType(Type.Sick).from(LocalDate.now())
				.to(LocalDate.of(2018, 2, 28)).build();
		System.out.println(application);
		System.out.println("**************************************************");
		LeaveApprover approver = createChain();
		approver.processLeaveApplication(application);
		System.out.println(application);
	}

	private static LeaveApprover createChain() {
		return new ProjectLead(new Manager(new Director(null)));
	}

}
