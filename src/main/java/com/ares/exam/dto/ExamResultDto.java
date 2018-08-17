package com.ares.exam.dto;
/**
 * 考试成绩封装 
 * @author szares02
 *
 */
public class ExamResultDto {
	//答题卷ID
	private Long answerSheetID;
	//警号
	private Long jh;
	//姓名
	private String xm;
	//得分
	private Float score;
	//ip地址
	private String addressIP;
	//是否及格
	private Integer isPass;
	public Long getAnswerSheetID() {
		return answerSheetID;
	}
	public void setAnswerSheetID(Long answerSheetID) {
		this.answerSheetID = answerSheetID;
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
	
	public String getAddressIP() {
		return addressIP;
	}
	public void setAddressIP(String addressIP) {
		this.addressIP = addressIP;
	}
	@Override
	public String toString() {
		return "ExamResultDto [answerSheetID=" + answerSheetID + ", jh=" + jh + ", xm=" + xm + ", score=" + score
				+ ", isPass=" + isPass + "]";
	}
	
}
