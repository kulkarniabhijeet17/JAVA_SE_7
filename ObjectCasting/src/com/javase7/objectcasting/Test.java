package com.javase7.objectcasting;

public class Test {
	public static void main(String[] args) {
		Parent p = new Parent();
		Parent pc = new Child();
		Child c = new Child();
		// Child cp = new Parent(); // Never possible

		System.out.println("1: " + p.parentMethod());
		System.out.println("2: " + pc.parentMethod());
		// System.out.println("3: " + pc.childSpecificMethod()); // gives compile time error
		System.out.println("4: " + c.parentMethod());

		// Explicit/Downcasting Casting: Parent to Child
		// Child c1 = (Child) p; // this will through ClassCastException

		// Explicit/Downcasting Casting: Parent to Child
		Child c2 = (Child) pc; // c2 access methods from child class
		System.out.println("5: " + c2.childSpecificMethod());

		// Straightforward conversion: Parent to Parent
		Parent p1 = pc; // p1 access methods from parent class
		System.out.println("6: " + p1.parentMethod()); // execute child class method

		// Implicit/Upcasting Casting: Child to Parent
		Parent p2 = (Parent) c; // p2 access methods from parent class
		System.out.println("7: " + p2.parentMethod()); // execute child class method

		// Implicit/Upcasting Casting: Child to Parent
		Parent p3 = c; // p3 access methods from parent class
		System.out.println("8: " + p3.parentMethod()); // execute child class method
	}
}