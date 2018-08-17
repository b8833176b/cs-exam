package com.ares.exam.dto;

import java.sql.Date;

public class QuestionBankDto {
	//题库ID
	private Long questionBankID;
	//题库名称
	private String questionBankName;
	//题库类型名称
	private String questionBankTypeName;
	//是否显示
	private String isDisplay;
	//题库创建时间
	private Date creationTime;
	//创建人
	private String founder;
	//更新时间
	private Date updateTime;
	//更新人
	private String updateMan;
	public Long getQuestionBankID() {
		return questionBankID;
	}
	public void setQuestionBankID(Long questionBankID) {
		this.questionBankID = questionBankID;
	}
	public String getQuestionBankName() {
		return questionBankName;
	}
	public void setQuestionBankName(String questionBankName) {
		this.questionBankName = questionBankName;
	}
	public String getQuestionBankTypeName() {
		return questionBankTypeName;
	}
	public void setQuestionBankTypeName(String questionBankTypeName) {
		this.questionBankTypeName = questionBankTypeName;
	}
	public String getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateMan() {
		return updateMan;
	}
	public void setUpdateMan(String updateMan) {
		this.updateMan = updateMan;
	}
	@Override
	public String toString() {
		return "QuestionBankDto [questionBankID=" + questionBankID + ", questionBankName=" + questionBankName
				+ ", questionBankTypeName=" + questionBankTypeName + ", isDisplay=" + isDisplay + ", creationTime="
				+ creationTime + ", founder=" + founder + ", updateTime=" + updateTime + ", updateMan=" + updateMan
				+ "]";
	}
	
}
