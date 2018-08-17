package com.ares.exam.exception;

public class NotExistException extends Exception{
	private static final long serialVersionUID = 1L;
	public NotExistException() {
		super();
	}
	public NotExistException(String msg) {
		super(msg);
	}
}
