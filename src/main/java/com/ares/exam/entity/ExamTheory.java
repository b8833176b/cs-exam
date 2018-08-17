package com.ares.exam.entity;

import java.sql.Timestamp;

/**
 * 理论成绩表
 * @author szares02
 *
 */
public class ExamTheory {
	private Long id;
	//成绩
	private String cj;
	//开班编号
	private Long kbbh;
	//状态
	private Integer zt;
	//成绩评定
	private String cjpd;
	//备注
	private String bz;
	//用户id
	private Long userID;
	//考试时间
	private Timestamp kssj;
	//考试ID
	private Long examID;
	//考试名称
	private String examName;
	//考试类型ID
	private Long examTypeID;
	//考试类型名称
	private Long examTypeName;
	//考试总分
	private Integer examzf;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCj() {
		return cj;
	}
	public void setCj(String cj) {
		this.cj = cj;
	}
	public Long getKbbh() {
		return kbbh;
	}
	public void setKbbh(Long kbbh) {
		this.kbbh = kbbh;
	}
	public Integer getZt() {
		return zt;
	}
	public void setZt(Integer zt) {
		this.zt = zt;
	}
	public String getCjpd() {
		return cjpd;
	}
	public void setCjpd(String cjpd) {
		this.cjpd = cjpd;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Timestamp getKssj() {
		return kssj;
	}
	public void setKssj(Timestamp kssj) {
		this.kssj = kssj;
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
	public Long getExamTypeID() {
		return examTypeID;
	}
	public void setExamTypeID(Long examTypeID) {
		this.examTypeID = examTypeID;
	}
	public Long getExamTypeName() {
		return examTypeName;
	}
	public void setExamTypeName(Long examTypeName) {
		this.examTypeName = examTypeName;
	}
	public Integer getExamzf() {
		return examzf;
	}
	public void setExamzf(Integer examzf) {
		this.examzf = examzf;
	}
	
}
