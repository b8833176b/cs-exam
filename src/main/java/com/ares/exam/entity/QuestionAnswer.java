package com.ares.exam.entity;

import com.ares.exam.util.Constants;

/**
 * 问答题类
 * @author szares02
 *
 */
public class QuestionAnswer extends Question{
	public QuestionAnswer() {
		super.setQuestionType(Constants.QuestionType.Answer.getValue());
	}
}
