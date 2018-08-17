package com.ares.exam.entity;

import com.ares.exam.util.Constants;
import com.ares.exam.util.StringUtil;

/**
 * 单选题
 * @author szares02
 *
 */
public class QuestionRadio extends Question{
	public QuestionRadio() {
		// TODO Auto-generated constructor stub
		super.setQuestionType(Constants.QuestionType.Radio.getValue());
	}
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String optionE;
	private String optionF;
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getOptionE() {
		return optionE;
	}
	public void setOptionE(String optionE) {
		this.optionE = optionE;
	}
	public String getOptionF() {
		
		return optionF;
	}
	public void setOptionF(String optionF) {
		this.optionF = optionF;
	}
	@Override
	public void setRightAnswer(String rightAnswer) {
		// TODO Auto-generated method stub
		if(StringUtil.isABCD(rightAnswer)) {
			super.setRightAnswer(rightAnswer.toUpperCase());
		}
	}
	@Override
	public String toString() {
		return "QuestionRadio [optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", optionD="
				+ optionD + ", optionE=" + optionE + ", optionF=" + optionF + "]";
	}
	
	
	 
	
}
