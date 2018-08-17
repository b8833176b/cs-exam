package com.ares.exam.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ares.exam.BaseTest;
import com.ares.exam.dto.ExamDto;
import com.ares.exam.entity.Exam;
import com.ares.exam.entity.PoliceInfo;

public class ExamDaoTest extends BaseTest{
	@Autowired
	private ExamDao examDao;
	@Test
	public void testAdd() {
		Exam exam=new Exam();
		exam.setAnswerScore(1.0F);
		exam.setClozeScore(1.0F);
		exam.setDescription("测试5");
		exam.setDisplay(1);
		exam.setStartTime(new java.sql.Date(new java.util.Date().getTime()));
		exam.setEndTime(new java.sql.Date(new java.util.Date().getTime()));
		exam.setExamName("测试5");
		exam.setExamTypeID(12L);
		exam.setFounderID(1L);
		exam.setJudgmentScore(1.0F);
		exam.setMultipleScore(1.0F);
		exam.setRadioScore(1.0F);
		exam.setTypingScore(1.0F);
		exam.setWhenLong(40);
		examDao.addExam(exam);
		System.out.println(exam.getExamID());
	}
	
	@Test
	public void testDel() {
		Exam exam=new Exam();
		exam.setExamID(1L);
		examDao.delExam(exam);
	}
	@Test
	public void testGet() {
		Exam exam=examDao.getExam(2L);
		System.out.println(exam);
	}
	
	@Test
	public void testQuery(){
		List<ExamDto> ls=examDao.queryExamDto(null);
		System.out.println(ls.get(0).getFounder());
	}
	
	@Test
	public void testqueryExamDtoByUser() {
		PoliceInfo pi =new PoliceInfo();
		pi.setUserID(450200000053L);
		List<ExamDto> ls=examDao.queryBeforeExamDtoByUser(pi);
		System.out.println(ls.size());
	}
	
	@Test
	public void testQuery2() {
		PoliceInfo pi=new PoliceInfo();
		pi.setUserID(450200000053L);
		List<ExamDto> ls=examDao.queryExamDtoByUser(pi);
		System.out.println(ls.get(0));
	}
}
