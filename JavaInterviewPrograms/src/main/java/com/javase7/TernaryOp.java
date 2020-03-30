package com.javase7;

public class TernaryOp {
	public static void main(String[] args) {
		boolean x = false;
		int a;
		if (x) {
			a = x ? 1 : 2;
		} else {
			a = x ? 3 : 4;
		}
		System.out.println(a); // output: 4
	}
}