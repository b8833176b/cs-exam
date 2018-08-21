package com.ares.exam.dto;
/**
 * 对答题进行封装
 * @author szares02
 *
 */
public class AnswerDto {
	//试题ID
	private Long questionID;
	//试题类型
	private Integer questionType;
	//试题内容
	private String questionContent;
	//题库ID
	private Long questionBankID;
	//正确答案
	private String rightAnswer;
	//答题ID
	private Long answerID;
	//答题卷ID
	private Long answerSheetID;
	//是否评阅 1-是 0-否
	private Integer isReview;
	//得分
	private Float score;
	//是否正确,1-是 0-否 对应问答题此属性可能用不上
	private Integer correct;
	//考生作答
	private String respondence;

	//每题分数
	private String questionscore;

	//单选题分数
	private String radioscore;
	//多选题分数
	private String multiplescore;
	//判断题分数
	private String judgmentscore;
	//填空题分数
	private String clozescore;
	//问答题分数
	private String answerscore;
	//打字题分数
	private String typingscore;

	public Long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}
	public Integer getQuestionType() {
		return questionType;
	}
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public Long getQuestionBankID() {
		return questionBankID;
	}
	public void setQuestionBankID(Long questionBankID) {
		this.questionBankID = questionBankID;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public Long getAnswerID() {
		return answerID;
	}
	public void setAnswerID(Long answerID) {
		this.answerID = answerID;
	}
	public Long getAnswerSheetID() {
		return answerSheetID;
	}
	public void setAnswerSheetID(Long answerSheetID) {
		this.answerSheetID = answerSheetID;
	}
	public Integer getIsReview() {
		return isReview;
	}
	public void setIsReview(Integer isReview) {
		this.isReview = isReview;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public Integer getCorrect() {
		return correct;
	}
	public void setCorrect(Integer correct) {
		this.correct = correct;
	}
	public String getRespondence() {
		return respondence;
	}
	public void setRespondence(String respondence) {
		this.respondence = respondence;
	}

	public String getRadioscore() {
		return radioscore;
	}

	public void setRadioscore(String radioscore) {
		this.radioscore = radioscore;
	}

	public String getMultiplescore() {
		return multiplescore;
	}

	public void setMultiplescore(String multiplescore) {
		this.multiplescore = multiplescore;
	}

	public String getJudgmentscore() {
		return judgmentscore;
	}

	public void setJudgmentscore(String judgmentscore) {
		this.judgmentscore = judgmentscore;
	}

	public String getClozescore() {
		return clozescore;
	}

	public void setClozescore(String clozescore) {
		this.clozescore = clozescore;
	}

	public String getAnswerscore() {
		return answerscore;
	}

	public void setAnswerscore(String answerscore) {
		this.answerscore = answerscore;
	}

	public String getTypingscore() {
		return typingscore;
	}

	public void setTypingscore(String typingscore) {
		this.typingscore = typingscore;
	}

	public String getQuestionscore() {
		return questionscore;
	}

	public void setQuestionscore(String questionscore) {
		this.questionscore = questionscore;
	}

	@Override
	public String toString() {
		return "AnswerDto{" +
				"questionID=" + questionID +
				", questionType=" + questionType +
				", questionContent='" + questionContent + '\'' +
				", questionBankID=" + questionBankID +
				", rightAnswer='" + rightAnswer + '\'' +
				", answerID=" + answerID +
				", answerSheetID=" + answerSheetID +
				", isReview=" + isReview +
				", score=" + score +
				", correct=" + correct +
				", respondence='" + respondence + '\'' +
				", questionscore='" + questionscore + '\'' +
				", radioscore='" + radioscore + '\'' +
				", multiplescore='" + multiplescore + '\'' +
				", judgmentscore='" + judgmentscore + '\'' +
				", clozescore='" + clozescore + '\'' +
				", answerscore='" + answerscore + '\'' +
				", typingscore='" + typingscore + '\'' +
				'}';
	}
}
