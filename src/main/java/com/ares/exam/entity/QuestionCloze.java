package com.ares.exam.entity;

import com.ares.exam.util.Constants;
/**
 * 填空题类
 * @author szares02
 *
 */
public class QuestionCloze extends Question{
	public QuestionCloze() {
		super.setQuestionType(Constants.QuestionType.Cloze.getValue());
	}
}
