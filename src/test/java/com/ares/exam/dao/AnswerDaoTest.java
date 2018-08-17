package com.ares.exam.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ares.exam.BaseTest;

public class AnswerDaoTest extends BaseTest{
	@Autowired
	private AnswerDao answerDao;
	@Test
	public void testCount() {
		int r=answerDao.getNoMarkCount(25L);
		System.out.println(r);
	}
}
