package com.ares.exam.entity;
import java.sql.Date;
/**
 * 答题卷类
 * @author lc
 *
 */
public class AnswerSheet {
	//答题卷ID
	private Long answerSheetID;
	//警员编号
	private Long userID;
	//考试编号
	private Long examID;
	//开始考试时间
	private Date startTime;
	//交卷时间
	private Date assignmentTime;
	//ip地址
	private String addressIP;
	//是否阅卷完成 0-否 1-是
	private Integer isMarking;
	//得分
	private Float score;
	//是否及格
	private Integer isPass;
	public Long getAnswerSheetID() {
		return answerSheetID;
	}
	public void setAnswerSheetID(Long answerSheetID) {
		this.answerSheetID = answerSheetID;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Long getExamID() {
		return examID;
	}
	public void setExamID(Long examID) {
		this.examID = examID;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getAssignmentTime() {
		return assignmentTime;
	}
	public void setAssignmentTime(Date assignmentTime) {
		this.assignmentTime = assignmentTime;
	}
	public String getAddressIP() {
		return addressIP;
	}
	public void setAddressIP(String addressIP) {
		this.addressIP = addressIP;
	}
	public Integer getIsMarking() {
		return isMarking;
	}
	public void setIsMarking(Integer isMarking) {
		this.isMarking = isMarking;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public Integer getIsPass() {
		return isPass;
	}
	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}
	
	
}
