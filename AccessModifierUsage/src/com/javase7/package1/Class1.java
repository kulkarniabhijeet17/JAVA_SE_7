package com.javase7.package1;

import com.javase7.package2.Class3;

public class Class1 extends Class3 {
	public void c1m1() {
		System.out.println("c1m1()");
	}

	void c1m2() {
		System.out.println("c1m2()");
	}

	protected void c1m3() {
		System.out.println("c1m3()");
	}

	private void c1m4() {
		System.out.println("c1m4()");
	}

	public static void main(String[] args) {
		Class1 c1 = new Class1();
		// All methods are accessed present in Class1
		c1.c1m1();
		c1.c1m2();
		c1.c1m3();
		c1.c1m4();

		// Only public and protected methods are accessed present in Class1
		c1.c3m1();
		c1.c3m3();

		Class2 c2 = new Class2();
		c2.c2m1();
		c2.c2m2();
		c2.c2m3();

		Class3 c3 = new Class3();
		c3.c3m1();
	}
}