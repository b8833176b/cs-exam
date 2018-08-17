package com.ares.exam.exception;
/**
 * 文件格式异常
 * @author szares02
 *
 */
public class FileFormatException extends Exception{
	private static final long serialVersionUID = 1L;
	public FileFormatException() {
		// TODO Auto-generated constructor stub
		super();
	}
	public FileFormatException(String msg) {
		super(msg);
	}
}
