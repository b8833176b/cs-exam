package com.ares.exam.entity;
/**
 * 考生考试关系类
 * @author szares02
 *
 */
public class ExamPoliceInfo {
	//映射关系id
	private Long examPoliceInfoID;
	//考试编号
	private Long examID;
	//警员编号
	private Long userID;
	//是否完成考试（交卷） 0 否 1已经开始但未交卷 2 已经完成
	private Integer isOver;
	public Long getExamPoliceInfoID() {
		return examPoliceInfoID;
	}
	public void setExamPoliceInfoID(Long examPoliceInfoID) {
		this.examPoliceInfoID = examPoliceInfoID;
	}
	public Long getExamID() {
		return examID;
	}
	public void setExamID(Long examID) {
		this.examID = examID;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Integer getIsOver() {
		return isOver;
	}
	public void setIsOver(Integer isOver) {
		this.isOver = isOver;
	}
	
}
