package com.javase7.operator.programs;

public class Example1 {
	public static void main(String[] args) {
		int i;
		int j;
		int k = 0;
		for (i = 0; i < 10; ++i) {
			for (j = 0; j < 10; ++j) {
				++k;
			}
		}
		System.out.println(k);
	}
}