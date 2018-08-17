package com.ares.exam.entity;
import java.sql.Date;
/**
 * 题库类
 * @author lc
 *
 */
public class QuestionBank {
	//题库ID
	private Long questionBankID;
	//题库名称
	private String questionBankName;
	//题库类型ID
	private Long questionBankTypeID;
	//是否显示，1显示，0不显示。默认不显示（考生是否练习）
	private Integer isDisplay;
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
	public Long getQuestionBankTypeID() {
		return questionBankTypeID;
	}
	public void setQuestionBankTypeID(Long questionBankTypeID) {
		this.questionBankTypeID = questionBankTypeID;
	}
	public Integer getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(Integer isDisplay) {
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
		return "QuestionBank [questionBankID=" + questionBankID + ", questionBankName=" + questionBankName
				+ ", isDisplay=" + isDisplay + ", creationTime=" + creationTime + ", founder=" + founder
				+ ", updateTime=" + updateTime + ", updateMan=" + updateMan + "]";
	}
}
