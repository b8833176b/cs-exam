package com.ares.exam.dto;
/**
 * 考试题库映射关系封装类
 * @author szares02
 *
 */
public class ExamQuestionBankDto {
	//映射关系ID
	private Long examQuestionBankID;
	//考试编号
	private Long useExamID;
	//试题数量
	private Integer questionCount;
	//使用的试题类型
	private Long useQuestionType;
	//题库ID
	private Long useQuestionBankID;
	//题库名称
	private String questionBankName;
	//题库类型名称
	private String questionBankTypeName;
	public Long getExamQuestionBankID() {
		return examQuestionBankID;
	}
	public void setExamQuestionBankID(Long examQuestionBankID) {
		this.examQuestionBankID = examQuestionBankID;
	}
	public Long getUseExamID() {
		return useExamID;
	}
	public void setUseExamID(Long useExamID) {
		this.useExamID = useExamID;
	}
	public Integer getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}
	public Long getUseQuestionType() {
		return useQuestionType;
	}
	public void setUseQuestionType(Long useQuestionType) {
		this.useQuestionType = useQuestionType;
	}
	public Long getUseQuestionBankID() {
		return useQuestionBankID;
	}
	public void setUseQuestionBankID(Long useQuestionBankID) {
		this.useQuestionBankID = useQuestionBankID;
	}
	public String getQuestionBankName() {
		return questionBankName;
	}
	public void setQuestionBankName(String questionBankName) {
		this.questionBankName = questionBankName;
	}
	public String getQuestionBankTypeName() {
		return questionBankTypeName;
	}
	public void setQuestionBankTypeName(String questionBankTypeName) {
		this.questionBankTypeName = questionBankTypeName;
	}
	

}
