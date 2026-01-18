package com.ps.dp.builder2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testMissingType() {
		assertThrows(IllegalArgumentException.class, () -> User.getBuilder(null));
	}

	@Test
	void testBuildUser() {
		final String name = "Prem";
		final Address address = Address.getBuilder().withState("Karnataka").withHouseNumber("GF3").withCity("BLR")
				.build();
		final var client = User.getBuilder(UserType.USER).withFirstName(name).withLastName("Rohan")
				.withBirthday(LocalDate.parse("1980-02-14")).withAddress(address).build();

		assertNotNull(client);
		assertNotNull(client.toString());
		assertEquals(UserType.USER, client.userType());
		assertEquals(name, client.firstName());
		assertEquals(address, client.address());

	}
}
