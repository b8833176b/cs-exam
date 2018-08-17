package com.ares.exam.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ares.exam.BaseTest;
import com.ares.exam.entity.ExamType;

public class ExamTypeDaoTest extends BaseTest{
	@Autowired
	private ExamTypeDao examTypeDao;
	@Test
	public void testQuery() {
		System.out.println(examTypeDao.queryExamType().size());
	}
	@Test
	public void testAdd() {
		ExamType examType=new ExamType();
		examType.setExamTypeName("考试类型测试");
		int r=examTypeDao.addExamType(examType);
		System.out.println(r);
	}
	@Test
	public void testDel() {
		ExamType examType=new ExamType();
		examType.setExamTypeID(4L);
		int r=examTypeDao.delExamType(examType);
		System.out.println(r);
	}
}
