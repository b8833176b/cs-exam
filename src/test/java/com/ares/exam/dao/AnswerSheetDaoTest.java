package com.ares.exam.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ares.exam.BaseTest;
import com.ares.exam.dto.ExamResultDto;
import com.ares.exam.dto.QueryAnswerSheetDto;

public class AnswerSheetDaoTest extends BaseTest{
	@Autowired
	private AnswerSheetDao answerSheetDao;
	@Test
	public void testQueryExamResultDtos() {
		QueryAnswerSheetDto qasd=new QueryAnswerSheetDto();
		qasd.setExamID(2L);
		List<ExamResultDto> ls=answerSheetDao.queryExamResultDtos(qasd);
		System.out.println(ls.get(0).toString());
	}
	public void testMarkSum() {
	//	answerSheetDao.markSum(answerSheetID);
	}
}
