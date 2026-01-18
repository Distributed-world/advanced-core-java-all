package com.ps.dp.builder2;

import java.time.LocalDate;

public record User(UserType userType, String firstName, String lastName, LocalDate birthday, Address address) {

	private User(UserBuilder b) {
		this(b.userType, b.firstName, b.lastName, b.birthday, b.address);
	}

	public static UserBuilder getBuilder(UserType userType) {
		return new UserBuilder(userType);
	}

	static class UserBuilder {
		private String firstName;
		private String lastName;
		private LocalDate birthday;
		private Address address;
		private UserType userType;

		private UserBuilder(UserType userType) {
			if (userType == null) {
				throw new IllegalArgumentException("User type Required!");

			}
			this.userType = userType;
		}

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
			return new User(this);
		}

	}

}
