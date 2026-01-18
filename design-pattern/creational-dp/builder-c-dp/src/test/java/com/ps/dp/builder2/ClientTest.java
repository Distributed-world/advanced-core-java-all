package com.ps.dp.builder2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class ClientTest extends TestCase {
	@Test
	void shouldExecuteApplicationWithoutException() {
		assertDoesNotThrow(() -> Client.main(new String[] {}));
	}
}
