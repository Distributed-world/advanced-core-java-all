package com.ps;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingletonEagerTest extends SingletonTest<SingletonEager> {

	public SingletonEagerTest() {
		super(SingletonEager::getInstance);
	}

}
