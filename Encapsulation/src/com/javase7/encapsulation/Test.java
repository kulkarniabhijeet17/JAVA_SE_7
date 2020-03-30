package com.javase7.encapsulation;

public class Test {
	public static void main(String[] args) {
		EncapsulationDemo t = new EncapsulationDemo();
		t.age = 10;
		t.lastName = "";
		t.firstName = "";
		// t.middleInitial = ""; // compilation error
	}
}