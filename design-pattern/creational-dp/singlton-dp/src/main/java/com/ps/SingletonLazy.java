package com.ps;

public class SingletonLazy {
	private static volatile SingletonLazy INSTANCE;

	private SingletonLazy() {
		super();
		System.out.println(this.getClass().getCanonicalName() + ": Constructor called....");
	}

	public static SingletonLazy getInstance() {
		if (INSTANCE == null) {
			synchronized (SingletonLazy.class) {
				if (INSTANCE == null) {
					INSTANCE = new SingletonLazy();
				}
			}
		}

		System.out.println("start getInstance....");
		return INSTANCE;
	}

}
