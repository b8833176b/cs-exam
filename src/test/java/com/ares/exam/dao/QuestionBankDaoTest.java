package com.ares.exam.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ares.exam.BaseTest;
import com.ares.exam.dto.QueryQuestionBankDto;
import com.ares.exam.dto.QuestionBankDto;
import com.ares.exam.entity.QuestionBank;


public class QuestionBankDaoTest extends BaseTest{
	@Autowired
	private QuestionBankDao questionBankDao;
	@Test
	public void testAddQuestionBank() {
		QuestionBankDto qb=new QuestionBankDto();
		qb.setQuestionBankName("测试添加X");
		qb.setFounder("天使之力");
		qb.setQuestionBankTypeName("插入测试2");
		questionBankDao.addQuestionBank(qb);
		
	}
	@Test
	public void testQueryQuestionBank() {
		List<QuestionBank> ls=questionBankDao.queryQuestionBank();
		for(QuestionBank key: ls) {
			System.out.println(key.getQuestionBankName());
		}
	}
	@Test
	public void testQueryQuestionBank2() {
		QuestionBank questionBank=new QuestionBank();
		questionBank.setQuestionBankID((long) 5);
		List<QuestionBank> ls=questionBankDao.queryQuestionBank(questionBank);
		for(QuestionBank key: ls) {
			System.out.println(key.getQuestionBankName());
		}
	}
	@Test
	public void testQueryQuestionBankDto() {
		QueryQuestionBankDto q=new QueryQuestionBankDto();
		
		
		List<QuestionBankDto> ls=questionBankDao.queryQuestionBankDto(q);
		System.out.println(ls.size());
		for(QuestionBankDto key:ls) {
			System.out.println(key);
		}
		
	}
	
	@Test
	public void testQueryCountByType() {
		int r=questionBankDao.queryCountByType(13L, 1L);
		System.out.println(r);
	}
	
	@Test
	public void testClean() {
		int r=questionBankDao.clean(14L);
		System.out.println(r);
	}
}
