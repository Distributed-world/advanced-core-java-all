package com.ps.dp.builder2;

public class Client {

	public static void main(String[] args) {
		User userWithOnlyFirstName = User.getBuilder(UserType.ADMIN).withFirstName("Prem").build();
		User userWithFirstNameAndLastName = User.getBuilder(UserType.USER).withFirstName("Prem").withLastName("Prakash").build();
		User userWithAddress = User.getBuilder(UserType.ADMIN).withFirstName("Prem").withLastName("Prakash")
				.withAddress(Address.getBuilder().withCity("BLR").build()).build();
	}

}
