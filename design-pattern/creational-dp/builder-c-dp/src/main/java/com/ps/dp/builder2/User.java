package com.ps.dp.builder2;

import java.time.LocalDate;


public class User {
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private Address address;

	private User() {
		super();
	}

	private User(String firstName, String lastName, LocalDate birthday, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public Address getAddress() {
		return address;
	}

	public static UserBuilder getBuilder() {
		return new UserBuilder();
	}

	static class UserBuilder {
		private String firstName;
		private String lastName;
		private LocalDate birthday;
		private Address address;

		public UserBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserBuilder withBirthday(LocalDate birthday) {
			this.birthday = birthday;
			return this;
		}

		public UserBuilder withAddress(Address address) {
			this.address = address;
			return this;
		}

		public User build() {
			return new User(firstName, lastName, birthday, address);
		}

	}

}
