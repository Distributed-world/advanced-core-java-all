package com.ps;

class SingletonLazyTest extends SingletonTest<SingletonLazy> {

	public SingletonLazyTest() {
		super(SingletonLazy::getInstance);
	}

}
