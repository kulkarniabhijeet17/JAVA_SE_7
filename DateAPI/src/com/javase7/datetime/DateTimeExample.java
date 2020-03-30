package com.javase7.datetime;

public class DateTimeExample {
	public static void main(String[] args) {
		System.out.println("System.currentTimeMillis():: " + System.currentTimeMillis());
		System.out.println("java.util.Date():: " + new java.util.Date());
		System.out.println("java.sql.Date():: " + new java.sql.Date(1));
		System.out.println("java.sql.Timestamp():: " + new java.sql.Timestamp(1));
		System.out.println("java.util.Calendar():: " + java.util.Calendar.getInstance());
		System.out.println("java.util.GregorianCalendar():: " + new java.util.GregorianCalendar());
	}
}