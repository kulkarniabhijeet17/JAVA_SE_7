package com.javase7.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializingObjectExample {
	public static void main(String[] args) {
		Address address = new Address("G-201, Shonest Tower", "Datta Mandir Road");
		User user = new User("Abhijeet", "Kulkarni", address);
		System.out.println("before: address line 1 is " + user.getAddress().getAddressLine1());
		try {
			FileOutputStream fs = new FileOutputStream("testSer.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(user);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("testSer.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			user = (User) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after: address line 1 is " + user.getAddress().getAddressLine1());
	}
}