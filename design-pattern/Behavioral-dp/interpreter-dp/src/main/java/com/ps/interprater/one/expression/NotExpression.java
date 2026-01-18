package com.ps.interprater.one.expression;

import com.ps.interprater.one.PermissionExpression;
import com.ps.interprater.one.User;

//Non-terminal expression
public class NotExpression implements PermissionExpression {
	private PermissionExpression pExpOne;

	public NotExpression(PermissionExpression pExpOne) {
		super();
		this.pExpOne = pExpOne;
	}

	@Override
	public boolean interpret(User user) {
		return !pExpOne.interpret(user);
	}

	@Override
	public String toString() {
		return "AndExpression [ NOT " + pExpOne +"]";
	}

}
