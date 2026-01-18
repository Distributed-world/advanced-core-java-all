package com.ps.interprater.one.expression;

import com.ps.interprater.one.PermissionExpression;
import com.ps.interprater.one.User;

//Non-terminal expression
public class ORExpression implements PermissionExpression {
	private PermissionExpression pExpOne;
	private PermissionExpression pExpTwo;

	public ORExpression(PermissionExpression pExpOne, PermissionExpression pExpTwo) {
		super();
		this.pExpOne = pExpOne;
		this.pExpTwo = pExpTwo;
	}

	@Override
	public boolean interpret(User user) {
		return pExpOne.interpret(user) || pExpTwo.interpret(user);
	}

	@Override
	public String toString() {
		return "AndExpression [" + pExpOne + " OR " + pExpTwo + "]";
	}

}
