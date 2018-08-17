package com.ares.exam.exception;
/**
 * 名称重复异常
 * @author szares02
 *
 */
public class NameRepeatException extends Exception{
	private static final long serialVersionUID = 1L;
	public NameRepeatException() {
		// TODO Auto-generated constructor stub
		super();
	}
	public NameRepeatException(String msg) {
		super(msg);
	}

}
