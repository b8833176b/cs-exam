package com.ares.exam.entity;

import java.util.List;

/**
 * 题库类型类
 * @author lc
 *
 */
public class QuestionBankType {
	//题库类型ID
	private Long questionBankTypeID;
	//题库类型名称
	private String questionBankTypeName;
	//对应题库
	private List<QuestionBank> questionBanks;
	
	public QuestionBankType() {
		// TODO Auto-generated constructor stub
	}
	public QuestionBankType(String questionBankTypeName) {
		// TODO Auto-generated constructor stub
		this.questionBankTypeName=questionBankTypeName;
	}
	public Long getQuestionBankTypeID() {
		return questionBankTypeID;
	}
	public void setQuestionBankTypeID(Long questionBankTypeID) {
		this.questionBankTypeID = questionBankTypeID;
	}
	public String getQuestionBankTypeName() {
		return questionBankTypeName;
	}
	public void setQuestionBankTypeName(String questBankTypeName) {
		this.questionBankTypeName = questBankTypeName;
	}
	
	public List<QuestionBank> getQuestionBanks() {
		return questionBanks;
	}
	public void setQuestionBanks(List<QuestionBank> questionBanks) {
		this.questionBanks = questionBanks;
	}
	@Override
	public String toString() {
		return "QuestionBankType [questionBankTypeID=" + questionBankTypeID + ", questionBankTypeName="
				+ questionBankTypeName + "]";
	}
	
}
