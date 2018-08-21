package com.ares.exam.dto;
/**
 * 答题卷封装
 * @author szares02
 *
 */
public class AnswerSheetDto {
	//答题卷ID
	private Long answerSheetID;
	//警员编号
	private Long userID;
	//考试编号
	private Long examID;
	//是否阅卷完成 0-否 1-是
	private Integer isMarking;
	//姓名
	private String xm;
	//部门编号
	private Long bmbh;
	//警号
	private String jh;
	//考试名称
    private String examName;

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
	public Integer getIsMarking() {
		return isMarking;
	}
	public void setIsMarking(Integer isMarking) {
		this.isMarking = isMarking;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public Long getBmbh() {
		return bmbh;
	}
	public void setBmbh(Long bmbh) {
		this.bmbh = bmbh;
	}

	public String getJh() {
		return jh;
	}

	public void setJh(String jh) {
		this.jh = jh;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	@Override
	public String toString() {
		return "AnswerSheetDto{" +
				"answerSheetID=" + answerSheetID +
				", userID=" + userID +
				", examID=" + examID +
				", isMarking=" + isMarking +
				", xm='" + xm + '\'' +
				", bmbh=" + bmbh +
				", jh='" + jh + '\'' +
				", examName='" + examName + '\'' +
				'}';
	}
}
