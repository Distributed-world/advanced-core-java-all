package com.ps;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientTest {

	@Test
	void shouldExecuteWithoutException() {
		assertDoesNotThrow(() -> Client.main(new String[] {}));
	}

}
