package com.ps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {

	public static void main(String[] args) {
		SingletonEager es = SingletonEager.getInstance();
		SingletonLazy ls = SingletonLazy.getInstance();
		SingletonInitializationHolder sih = SingletonInitializationHolder.getInstance();
		SingltonEnum se = SingltonEnum.INSTANCE;
	}

}
