package com.javase7.objectcasting;

public class Child extends Parent {
	String parentMethod() {
		return "child method";
	}

	String childSpecificMethod() {
		return "child specific method";
	}
}