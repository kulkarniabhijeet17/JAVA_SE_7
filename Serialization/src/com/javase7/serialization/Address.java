package com.javase7.serialization;

public class Address {
	private String addressLine1; // flat number, apartment name
	private String addressLine2; // area, street name
	private String zipCode;
	private String city;
	private String stateCode;
	private String countryCode;

	public Address(String addressLine1, String addressLine2) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine1() {
		return addressLine1;
	}
}