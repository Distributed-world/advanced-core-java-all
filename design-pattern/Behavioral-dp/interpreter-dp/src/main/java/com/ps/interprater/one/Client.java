package com.ps.interprater.one;

import com.coffeepoweredcrew.interpreter.ExpressionBuilder;
import com.coffeepoweredcrew.interpreter.PermissionExpression;
import com.coffeepoweredcrew.interpreter.Report;
import com.coffeepoweredcrew.interpreter.User;

public class Client {

	public static void main(String[] args) {
		Report report1 = new Report("Cashflow repot", "FINANCE_ADMIN OR ADMIN");
		ExpressionBuilder builder = new ExpressionBuilder();

		PermissionExpression exp = builder.build(report1);
		System.out.println(exp);

		User user1 = new User("Dave", "USER","ADMIN");

		System.out.println("User access report:" + exp.interpret(user1));
		Report report2 = new Report("Cashflow repot", "NOT ADMIN");

		PermissionExpression exp2 = builder.build(report2);
		System.out.println(exp2);

		User user2 = new User("Dave", "USER","ADMIN");

		System.out.println("User access report:" + exp2.interpret(user2));
	}

}
