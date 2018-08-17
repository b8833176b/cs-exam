package com.ares.exam.dto;
import java.util.ArrayList;
/**
 * 考试试题封装
 * @author szares02
 *
 */
import java.util.List;
import com.ares.exam.entity.Question;
public class ExamQuestionInfoDto {
	private ExamDto ed;
	private List<Question> questions;
	
	public ExamQuestionInfoDto() {

		this.questions = new ArrayList<>();
	}
	public ExamDto getEd() {
		return ed;
	}
	public void setEd(ExamDto ed) {
		this.ed = ed;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public void addQuestions(List<Question> ls) {
		this.questions.addAll(ls);
	}
}
