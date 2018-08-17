package com.ares.exam.entity;
/**
 * 考试和题库关系映射类
 * @author szares02
 *
 */
public class ExamQuestionBank {
	//映射关系ID
	private Long examQuestionBankID;
	//考试编号
	private Long useExamID;
	//题库ID
	private Long useQuestionBankID;
	//使用的试题类型
	private Long useQuestionType;
	//试题数量
	private Integer questionCount;

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
	public Long getUseQuestionBankID() {
		return useQuestionBankID;
	}
	public void setUseQuestionBankID(Long useQuestionBankID) {
		this.useQuestionBankID = useQuestionBankID;
	}
	public Long getUseQuestionType() {
		return useQuestionType;
	}
	public void setUseQuestionType(Long useQuestionType) {
		this.useQuestionType = useQuestionType;
	}
	public Integer getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}
	@Override
	public String toString() {
		return "ExamQuestionBank [examQuestionBankID=" + examQuestionBankID + ", useExamID=" + useExamID
				+ ", useQuestionBankID=" + useQuestionBankID + ", useQuestionType=" + useQuestionType
				+ ", questionCount=" + questionCount + "]";
	}
	
	
	
}
