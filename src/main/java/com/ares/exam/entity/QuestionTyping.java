package com.ares.exam.entity;

import com.ares.exam.util.Constants;
/**
 * 打字题类
 * @author szares02
 *
 */
public class QuestionTyping extends Question{
	public QuestionTyping() {
		super.setQuestionType(Constants.QuestionType.typing.getValue());
	}
}
