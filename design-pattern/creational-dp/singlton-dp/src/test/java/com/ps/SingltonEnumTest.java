package com.ps;

class SingltonEnumTest extends SingletonTest<SingltonEnum> {

	public SingltonEnumTest() {
		super(() -> SingltonEnum.INSTANCE);
	}

}
