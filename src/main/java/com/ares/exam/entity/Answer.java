package com.ares.exam.entity;
/**
 * 答题类(目前只保存问答题)
 * @author lc
 *
 */
public class Answer {
	//答题ID
	private Long answerID;
	//答题卷ID
	private Long answerSheetID;
	//试题ID
	private Long questionID;
	//是否评阅 1-是 0-否
	private Integer isReview;
	//得分
	private Float score;
	//是否正确,1-是 0-否 对应问答题此属性可能用不上
	private Integer correct;
	//考生作答
	private String respondence;
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
	public Long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
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
	@Override
	public String toString() {
		return "Answer[questionID=" + questionID + ", correct=" + correct + ", respondence=" + respondence + "]";
	}
}
