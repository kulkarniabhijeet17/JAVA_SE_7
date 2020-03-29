package com.javase7.string;

public class Test {
	public static void main(String[] args) {
		String s1 = "Abhijeet";
		String s2 = new String(s1);
		String s3 = "Abhijeet";
		System.out.println(s1.equals(s2) + " " + s1.equals(s3) + " " + s2.equals(s3)); // true true true
		System.out.println(s1 == s2); // false
		System.out.println(s1 == s3); // true
		System.out.println(s2 == s3); // false
	}
}