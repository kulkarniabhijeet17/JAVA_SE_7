package com.javase7.exception;

public class BankOrganizerException extends Exception {
	private static final long serialVersionUID = 1L;

	public BankOrganizerException(String message) {
		super(message);
	}

	public BankOrganizerException(Throwable throwable) {
		super(throwable);
	}

	public BankOrganizerException(String message, Throwable throwable) {
		super(message, throwable);
	}
}