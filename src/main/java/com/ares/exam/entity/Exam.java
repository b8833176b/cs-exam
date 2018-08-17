package com.ares.exam.entity;
/**
 * 考试类
 * @author lc
 *
 */
import java.sql.Date;
public class Exam {
	//考试编号
	private Long examID;
	//考试名称
	private String examName;
	//考试类型ID
	private Long examTypeID;
	//开始时间
	private Date startTime;
	//结束时间
	private Date endTime;
	//能否失去焦点
	private Integer canBlur;
	//考试时长(分钟)
	private Integer whenLong;
	//考试描述
	private String description;
	//是否显示
	private Integer display;
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
	public Long getExamID() {
		return examID;
	}
	public void setExamID(Long examID) {
		this.examID = examID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Long getExamTypeID() {
		return examTypeID;
	}
	public void setExamTypeID(Long examTypeID) {
		this.examTypeID = examTypeID;
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
	public Integer getDisplay() {
		return display;
	}
	public void setDisplay(Integer display) {
		this.display = display;
	}

	public Long getFounderID() {
		return founderID;
	}

	public void setFounderID(Long founderID) {
		this.founderID = founderID;
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

	public Integer getCanBlur() {
		return canBlur;
	}
	public void setCanBlur(Integer canBlur) {
		this.canBlur = canBlur;
	}
	
}
