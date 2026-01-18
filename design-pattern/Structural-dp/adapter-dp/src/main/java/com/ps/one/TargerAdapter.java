package com.ps.one;

public class TargerAdapter implements Target {
	private Adaptee adaptee;

	public TargerAdapter(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void todo() {
		adaptee.adapteeTodo();
		
	}

}
