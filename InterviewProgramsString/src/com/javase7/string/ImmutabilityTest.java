package com.javase7.string;

public class ImmutabilityTest {
	private static String firstName = "Abhijeet";
	private static String lastName = "Kulkarni";
	private static StringBuffer sb1 = new StringBuffer("Abhijeet");
	private static StringBuffer sb2 = new StringBuffer("Kulkarni");

	public static void main(String[] args) {
		firstName.concat(lastName);
		System.out.println("String Concatenation 1:: " + firstName);

		System.out.println("String Concatenation 2:: " + firstName.concat(lastName));

		sb1.append(sb2);
		System.out.println("String Buffer Concatenation:: " + sb1);
	}
}