package com.ps;

public class SingletonEager {
	private static final SingletonEager INSTANCE = new SingletonEager();

	private SingletonEager() {
		super();
		System.out.println(this.getClass().getCanonicalName()+": Constructor called....");
	}

	public static SingletonEager getInstance() {
		System.out.println("start getInstance....");
		return INSTANCE;
	}

}
