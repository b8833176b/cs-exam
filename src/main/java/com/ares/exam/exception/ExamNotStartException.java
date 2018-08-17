package com.ares.exam.exception;
/**
 * 考试无法开始异常
 * @author szares02
 *
 */
public class ExamNotStartException extends Exception{
	private static final long serialVersionUID = 1L;
	public ExamNotStartException() {
		super();
	}
	public ExamNotStartException(String msg){
		super(msg);
	}

}
