package com.ps.interprater.one.expression;

import java.util.Stack;
import java.util.StringTokenizer;

import com.ps.interprater.one.Permission;
import com.ps.interprater.one.PermissionExpression;
import com.ps.interprater.one.Report;

public class ExpressionBuilder {
	private Stack<PermissionExpression> permissions = new Stack<>();
	private Stack<String> operators = new Stack<>();

	public PermissionExpression build(Report report) {
		parse(report.getPermission());
		buildExpressions();
		if (permissions.size() > 1 || !operators.isEmpty()) {
			System.out.println("ERROR!");
		}
		return permissions.pop();
	}

	private void buildExpressions() {
		while (!operators.isEmpty()) {
			String operator = operators.pop();
			PermissionExpression p1, p2, exp;
			switch (operator) {
			case "not":
				p1 = permissions.pop();
				exp = new NotExpression(p1);
				break;
			case "and":
				p1 = permissions.pop();
				p2 = permissions.pop();
				exp = new AndExpression(p1, p2);
				break;
			case "or":
				p1 = permissions.pop();
				p2 = permissions.pop();
				exp = new ORExpression(p1, p2);
				break;
			default:
				throw new IllegalArgumentException("Unknown operator:" + operator);
			}
			permissions.push(exp);
		}

	}

	private void parse(String permission) {
		StringTokenizer tokenizer = new StringTokenizer(permission.toLowerCase());

		while (tokenizer.hasMoreElements()) {
			String token;
			switch ((token = tokenizer.nextToken())) {
			case "and": {
				operators.push("and");
				break;
			}
			case "not": {

				operators.push("not");
				break;
			}
			case "or": {

				operators.push("or");
				break;
			}
			default:
				permissions.push(new Permission(token));
				break;
			}
		}

	}
}
