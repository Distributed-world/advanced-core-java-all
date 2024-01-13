package com.ps;

public class Client {

	public static void main(String[] args) {
		SingletonEager es = SingletonEager.getInstance();
		SingletonLazy ls = SingletonLazy.getInstance();
		SingletonInitializationHolder sih = SingletonInitializationHolder.getInstance();
		SingltonEnum se = SingltonEnum.INSTANCE;
	}

}
