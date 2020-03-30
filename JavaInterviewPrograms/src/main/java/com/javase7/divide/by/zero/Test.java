package com.javase7.divide.by.zero;

public class Test {
	public static void main(String[] args) {
		int x = 0;
		try {
			int y = 5 / x;
		} catch (ArithmeticException ae) {
			System.out.println("one");
		} catch (Exception e) {
			System.out.println("two");
		} finally {
			System.out.println("four");
		}
		System.out.println("five");
	}
}