package com.ares.exam.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ares.exam.BaseTest;
import com.ares.exam.entity.Question;
import com.ares.exam.entity.QuestionRadio;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.QuestionService;
public class QuestionDaoTest extends BaseTest{
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private QuestionService questionService;
	@Test
	public void testDelQuestion() {
		QuestionRadio questionRadio=new QuestionRadio();
		questionRadio.setQuestionID(15L);
		questionDao.delQuestion(15L);
	}
	@Test
	public void testDelQuestion2() {
		Question question=new Question();
		question.setQuestionID((long) 15);
	//	int r=questionDao.delQuestion(question);
		try {
			questionService.delQuestion((long) 15);
		} catch (ParameterNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryQuestion() {
		Question question=new Question();
		question.setQuestionID(16L);
		Question question2=questionDao.getQuestionById(question.getQuestionID());
		/*if(question2 instanceof QuestionRadio) {
			QuestionRadio qr=(QuestionRadio) question2;
			System.out.println(qr);
		}*/
		System.out.println(question2);
	}
	
	@Test
	public void testRandomQueryQuestion() {
		List<Question> ls=questionDao.randomQueryQuestion(13L, 1, 1L);
		System.out.println(ls.get(0).toString());
	}
	
}
