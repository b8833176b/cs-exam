package com.ares.exam.entity;
/**
 * 题目类
 * @author lc
 *
 */
public class Question {
	//试题ID
	Long questionID;
	//试题类型
	Integer questionType;
	//试题内容
	String questionContent;
	//题库ID
	Long questionBankID;
	//正确答案
	String rightAnswer;
	public Long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}
	public Long getQuestionBankID() {
		return questionBankID;
	}
	public void setQuestionBankID(Long questionBankID) {
		this.questionBankID = questionBankID;
	}
	public Integer getQuestionType() {
		return questionType;
	}
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", questionType=" + questionType + ", questionContent="
				+ questionContent + ", questionBankID=" + questionBankID + ", rightAnswer=" + rightAnswer + "]";
	}
	 
	
}
