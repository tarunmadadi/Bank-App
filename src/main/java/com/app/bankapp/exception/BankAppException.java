package com.app.bankapp.exception;

import org.springframework.http.HttpStatus;

public class BankAppException extends RuntimeException {

	private static final long serialVersionUID = 30028575982092168L;
	private final HttpStatus status;
	/**
	 * The default constructor
	 */
	public BankAppException() {
		super();
		status = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	/**
	 * Constructs an exception instance with message
	 * @param message
	 */
	public BankAppException(String message) {
		super(message);
		status = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	/**
	 * Constructs an exception with cause
	 * @param cause
	 */
	public BankAppException(Throwable cause) {
		super(cause);
		status = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	/**
	 * Constructs an exception with cause and message
	 * @param message
	 * @param cause
	 */
	public BankAppException(String message, Throwable cause) {
		super(message, cause);
		status = HttpStatus.INTERNAL_SERVER_ERROR;
	}
	/**
	 * Constructs an exception with cause and message and HTTP status
	 * @param message
	 * @param cause
	 * @param status
	 */
	public BankAppException(String message, Throwable cause, HttpStatus status) {
		super(message, cause);
		this.status = status;
	}
	/**
	 * Constructs an exception with HTTP status and message
	 * @param status
	 */
	public BankAppException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	/**
	 * Constructs an exception with HTTP status
	 * @param status
	 */
	public BankAppException(HttpStatus status) {
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
}
