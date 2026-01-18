package com.ps;

class SingletonInitializationHolderTest extends SingletonTest<SingletonInitializationHolder> {

	public SingletonInitializationHolderTest() {

		super(SingletonInitializationHolder::getInstance);
	}

}
