package com.ares.exam.entity;
/**
 * 考试成绩类(对应答题卷的成绩)
 * @author lc
 *
 */
public class ExamResult {
	//成绩ID
	private Long examResultID;
	//答题卷ID
	private Long answerSheetID;
	//分数
	private Float score;
	//是否及格 1-合格 2-不合格
	private Integer isPass;
	public Long getExamResultID() {
		return examResultID;
	}
	public void setExamResultID(Long examResultID) {
		this.examResultID = examResultID;
	}
	public Long getAnswerSheetID() {
		return answerSheetID;
	}
	public void setAnswerSheetID(Long answerSheetID) {
		this.answerSheetID = answerSheetID;
	}
	public Integer getIsPass() {
		return isPass;
	}
	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public Integer getPass() {
		return isPass;
	}
	public void setPass(Integer isPass) {
		this.isPass = isPass;
	}
	
	
}
