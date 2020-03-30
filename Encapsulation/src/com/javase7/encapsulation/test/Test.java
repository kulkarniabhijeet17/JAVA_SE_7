package com.javase7.encapsulation.test;

import com.javase7.encapsulation.EncapsulationDemo;

public class Test {
	public static void main(String[] args) {
		EncapsulationDemo t = new EncapsulationDemo();
		t.age = 10;
		// t.lastName = ""; // compilation error
		// t.firstName = ""; // compilation error
		// t.middleInitial = ""; // compilation error
	}
}