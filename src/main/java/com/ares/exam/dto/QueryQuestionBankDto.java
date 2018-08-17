package com.ares.exam.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用于封装查询参数
 * @author szares02
 *
 */
public class QueryQuestionBankDto {
		//题库ID
		private Long questionBankID;
		//题库名称
		private String questionBankName;
		//题库类型名称
		private Long questionBankTypeID;
		//是否显示
		private Integer isDisplay;
		//题库创建时间开始
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date startCreationTime;
		//题库创建时间结束
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date endCreationTime;
		//创建人
		private String founder;
		//更新时间
		private String startUpdateTime;
		//更新人
		private String endUpdateMan;
		public Long getQuestionBankID() {
			return questionBankID;
		}
		public void setQuestionBankID(Long questionBankID){
			this.questionBankID = questionBankID;
		}
		public String getQuestionBankName() {
			return questionBankName;
		}
		public void setQuestionBankName(String questionBankName) {
			this.questionBankName=questionBankName;
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
		public String getFounder() {
			return founder;
		}
		public void setFounder(String founder) {
			this.founder = founder;
		}
		public Date getStartCreationTime() {
			return startCreationTime;
		}
		public void setStartCreationTime(Date startCreationTime) {
			this.startCreationTime = startCreationTime;
		}
		public Date getEndCreationTime() {
			return endCreationTime;
		}
		public void setEndCreationTime(Date endCreationTime) {
			this.endCreationTime = endCreationTime;
		}
		public String getStartUpdateTime() {
			return startUpdateTime;
		}
		public void setStartUpdateTime(String startUpdateTime) {
			this.startUpdateTime = startUpdateTime;
		}
		public String getEndUpdateMan() {
			return endUpdateMan;
		}
		public void setEndUpdateMan(String endUpdateMan) {
			this.endUpdateMan = endUpdateMan;
		}
		@Override
		public String toString() {
			return "QueryQuestionBankDto [questionBankID=" + questionBankID + ", questionBankName=" + questionBankName
					+ ", questionBankTypeName=" + questionBankTypeID + ", isDisplay=" + isDisplay
					+ ", startCreationTime=" + startCreationTime + ", endCreationTime=" + endCreationTime + ", founder="
					+ founder + ", startUpdateTime=" + startUpdateTime + ", endUpdateMan=" + endUpdateMan + "]";
		}
		
		
}
