package com.ares.exam.dto;

/**
 * 考试成绩查询参数封装
 * @author szares02
 *
 */
public class QueryAnswerSheetDto {
	//考试编号
	private Long examID;
	//警号
	private Long jh;
	//姓名
	private String xm;
	public Long getExamID() {
		return examID;
	}
	public void setExamID(Long examID) {
		this.examID = examID;
	}
	public Long getJh() {
		return jh;
	}
	public void setJh(Long jh) {
		this.jh = jh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
}
