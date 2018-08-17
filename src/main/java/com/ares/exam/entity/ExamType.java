package com.ares.exam.entity;
/**
 * 考试类型类
 * @author lc
 *
 */
public class ExamType {
	//考试类型ID
	private Long examTypeID;
	//考试类型名称
	private String examTypeName;
	public Long getExamTypeID() {
		return examTypeID;
	}
	public void setExamTypeID(Long examTypeID) {
		this.examTypeID = examTypeID;
	}
	public String getExamTypeName() {
		return examTypeName;
	}
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}
	
}
