package com.ps.dp.builder3;

import java.time.LocalDate;

public class Client {

	public static void main(String[] args) {
		User userWithOnlyFirstName = User.getBuilder().withFirstName("Prem").build();
		User userWithFirstNameAndLastName = User.getBuilder().withFirstName("Prem").withLastName("Prakash").build();
		User userWithAddress = User.getBuilder().withFirstName("Prem").withLastName("Prakash")
				.withAddress(Address.getBuilder().withCity("BLR").build()).build();

	}

}
