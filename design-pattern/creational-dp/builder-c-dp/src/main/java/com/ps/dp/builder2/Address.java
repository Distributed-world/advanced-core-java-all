package com.ps.dp.builder2;

public record Address(String houseNumber, String street, String city, String zipcode, String state) {
	private Address(AddressBuilder builder) {
		this(builder.houseNumber, builder.street, builder.city, builder.zipcode, builder.state);
	}
	public static AddressBuilder getBuilder() {
		return new AddressBuilder();
	}
	public static class AddressBuilder {
		private String houseNumber;

		private String street;

		private String city;

		private String zipcode;

		private String state;

		public AddressBuilder withHouseNumber(String houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		public AddressBuilder withStreet(String street) {
			this.street = street;
			return this;
		}

		public AddressBuilder withCity(String city) {
			this.city = city;
			return this;
		}

		public AddressBuilder withZipcode(String zipcode) {
			this.zipcode = zipcode;
			return this;
		}

		public AddressBuilder withState(String state) {
			this.state = state;
			return this;
		}

		public Address build() {
			return new Address(this);
		}
	}
}
