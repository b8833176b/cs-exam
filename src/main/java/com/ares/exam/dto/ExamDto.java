package com.ares.exam.dto;

import java.sql.Date;

/**
 * 考试封装
 * @author szares02
 *
 */
public class ExamDto {
	    //考试编号
		private Long examID;
		//考试名称
		private String examName;
		//考试类型
		private String examTypeName;
		//考试类型ID
		private Long examTypeID;
		//开始时间
		private Date startTime;
		//结束时间
		private Date endTime;
		//考试时长(分钟)
		private Integer whenLong;
		//考试描述
		private String description;
		//创建人
		private String founder;
		//创建人ID
		private Long founderID;
		//单选题分数
		private Float radioScore;
		//多选题分数
		private Float multipleScore;
		//判断题分数
		private Float judgmentScore;
		//填空题分数
		private Float clozeScore;
		//问答题分数
		private Float answerScore;
		//打字题分数
		private Float typingScore;
		//是否显示
		private Integer display;
		//能否失去焦点
		private Integer canBlur;
		public Integer getCanBlur() {
			return canBlur;
		}
		public void setCanBlur(Integer canBlur) {
			this.canBlur = canBlur;
		}
		public Integer getDisplay() {
			return display;
		}
		public void setDisplay(Integer display) {
			this.display = display;
		}
		public Long getExamID() {
			return examID;
		}
		public void setExamID(Long examID) {
			this.examID = examID;
		}
		public String getExamName() {
			return examName;
		}
		public void setExamName(String examName) {
			this.examName = examName;
		}
		
		public String getExamTypeName() {
			return examTypeName;
		}
		public void setExamTypeName(String examTypeName) {
			this.examTypeName = examTypeName;
		}
		public Date getStartTime() {
			return startTime;
		}
		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}
		public Date getEndTime() {
			return endTime;
		}
		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}
		public Integer getWhenLong() {
			return whenLong;
		}
		public void setWhenLong(Integer whenLong) {
			this.whenLong = whenLong;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		public String getFounder() {
			return founder;
		}
		public void setFounder(String founder) {
			this.founder = founder;
		}
		public Float getRadioScore() {
			return radioScore;
		}
		public void setRadioScore(Float radioScore) {
			this.radioScore = radioScore;
		}
		public Float getMultipleScore() {
			return multipleScore;
		}
		public void setMultipleScore(Float multipleScore) {
			this.multipleScore = multipleScore;
		}
		public Float getJudgmentScore() {
			return judgmentScore;
		}
		public void setJudgmentScore(Float judgmentScore) {
			this.judgmentScore = judgmentScore;
		}

	public Float getClozeScore() {
		return clozeScore;
	}

	public void setClozeScore(Float clozeScore) {
		this.clozeScore = clozeScore;
	}

	public Float getAnswerScore() {
		return answerScore;
	}

	public void setAnswerScore(Float answerScore) {
		this.answerScore = answerScore;
	}

	public Float getTypingScore() {
		return typingScore;
	}

	public void setTypingScore(Float typingScore) {
		this.typingScore = typingScore;
	}

	public Long getFounderID() {
			return founderID;
		}
		public void setFounderID(Long founderID) {
			this.founderID = founderID;
		}
		
		public Long getExamTypeID() {
			return examTypeID;
		}
		public void setExamTypeID(Long examTypeID) {
			this.examTypeID = examTypeID;
		}
		@Override
		public String toString() {
			return "ExamDto [examID=" + examID + ", examName=" + examName + ", examType=" + examTypeName + ", startTime="
					+ startTime + ", endTime=" + endTime + ", whenLong=" + whenLong + ", description=" + description
					+ ", founder=" + founder + ", founderID=" + founderID + ", radioScore=" + radioScore
					+ ", multipleScore=" + multipleScore + ", judgmentScore=" + judgmentScore + ", ClozeScore="
					+ clozeScore + ", AnswerScore=" + answerScore + ", TypingScore=" + typingScore + ", display="
					+ display + "]";
		}
		
}
