package com.ares.exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ares.exam.BaseTest;
import com.ares.exam.dto.PoliceInfoDto;
import com.ares.exam.entity.Exam;
import com.ares.exam.entity.ExamPoliceInfo;
import com.ares.exam.entity.PoliceInfo;

public class ExamPoliceInfoDaoTest extends BaseTest{
	@Autowired
	private ExamPoliceInfoDao examPoliceInfoDao;
	@Test
	public void addTest() {
		ExamPoliceInfo epi=new ExamPoliceInfo();
		epi.setExamID(2L);
		epi.setUserID(450200000053L);
		examPoliceInfoDao.add(epi);
	}
	
	@Test
	public void delTest() {
		ExamPoliceInfo epi=new ExamPoliceInfo();
		epi.setExamPoliceInfoID(2L);
		examPoliceInfoDao.del(epi);
	}
	
	@Test
	public void testQuery() {
		Exam exam =new Exam();
		exam.setExamID(2L);
		List<PoliceInfo> ls=examPoliceInfoDao.queryPoliceInfoDtoByExam(exam);
		System.out.println(ls.size());
	}
	
	@Test
	public void testAddExamPoliceInfo() {
		List<ExamPoliceInfo> ls=new ArrayList<>();
		ExamPoliceInfo e1=new ExamPoliceInfo();
		e1.setExamID(2L);
		e1.setUserID(450200000053L);
		
		ExamPoliceInfo e2=new ExamPoliceInfo();
		e2.setExamID(2L);
		e2.setUserID(450200000091L);
		ls.add(e1);
		ls.add(e2);
		int r=examPoliceInfoDao.addExamPoliceInfo(ls);
		System.out.println(r);
	}
	
	@Test
	public void testClean() {
		int r=examPoliceInfoDao.clean(2L);
		System.out.println(r);
	}
	
	@Test 
	public void testQueryPoliceInfo() {       
		List<PoliceInfoDto> l=examPoliceInfoDao.getPoliceInfoDtoByExamID(59L);
		System.out.println(l.get(0).toString());
	}
	@Test
	public void testget() {
		ExamPoliceInfo epi=examPoliceInfoDao.get(2L, 450200000053L);
		System.out.println(epi);
	}
}
