package com.ps;

public class SingletonInitializationHolder {
	private SingletonInitializationHolder() {
		super();
	}

	private static class InitializationHolder {
		static final SingletonInitializationHolder INSTANCE = new SingletonInitializationHolder();
	}

	public static SingletonInitializationHolder getInstance() {
		return InitializationHolder.INSTANCE;
	}
}
