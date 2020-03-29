package com.javase7.serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private transient Address address;

	public User(String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	private void writeObject(ObjectOutputStream os) {
		try {
			os.defaultWriteObject();
			os.writeChars(address.getAddressLine1());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readObject(ObjectInputStream is) {
		try {
			is.defaultReadObject();
			address = new Address(is.readLine(), "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}