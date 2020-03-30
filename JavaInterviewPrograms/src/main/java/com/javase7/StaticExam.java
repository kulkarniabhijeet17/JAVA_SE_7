package com.javase7;

public class StaticExam {
	static int i = 10;
	static int j = 10;

	public static void main(String[] args) {
		StaticExam s = new StaticExam();
		s.i += s.j;
		System.out.println(i); // output: 20
	}
}