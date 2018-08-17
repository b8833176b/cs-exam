package com.ares.exam.entity;

import com.ares.exam.util.Constants;

/**
 * 判断题类
 * @author szares02
 *
 */
public class QuestionJudgment extends Question{
	public QuestionJudgment() {
		// TODO Auto-generated constructor stub
		super.setQuestionType(Constants.QuestionType.Judgment.getValue());
	}
	/**
	 * 判断题答案只可能是Y或者N
	 */
	@Override
	public void setRightAnswer(String rightAnswer) {
		// TODO Auto-generated method stub
		if(rightAnswer!=null&&(rightAnswer.startsWith("Y")||rightAnswer.equals("y"))) {
			super.setRightAnswer("Y");
		}else {
			super.setRightAnswer("N");
		}
	}
}
