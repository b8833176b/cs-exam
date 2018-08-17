package com.ares.exam.dto;
/**
 * 练习系统请求参数
 * @author szares02
 *
 */
public class TrainParaDto {
	//题库ID
	private Long questionBankID;
	//题库名称
	private String questionBankName;
	//试题类型
	private Long questionType;
	//试题数量
	private Integer questionCount;
	public Long getQuestionBankID() {
		return questionBankID;
	}
	public void setQuestionBankID(Long questionBankID) {
		this.questionBankID = questionBankID;
	}
	public String getQuestionBankName() {
		return questionBankName;
	}
	public void setQuestionBankName(String questionBankName) {
		this.questionBankName = questionBankName;
	}
	
	public Long getQuestionType() {
		return questionType;
	}
	public void setQuestionType(Long questionType) {
		this.questionType = questionType;
	}
	public Integer getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}
	
}
