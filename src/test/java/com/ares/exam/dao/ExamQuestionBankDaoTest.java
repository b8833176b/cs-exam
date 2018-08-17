package com.ares.exam.dao;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ares.exam.BaseTest;
import com.ares.exam.dto.QuestionBankDto;
import com.ares.exam.entity.Exam;
import com.ares.exam.entity.ExamQuestionBank;

public class ExamQuestionBankDaoTest extends BaseTest{
	@Autowired
	private ExamQuestionBankDao examQuestionBankDao;
	@Test
	public void testAdd() {
		ExamQuestionBank examQuestionBank=new ExamQuestionBank();
		examQuestionBank.setQuestionCount(40);
		examQuestionBank.setUseExamID(2L);
		examQuestionBank.setUseQuestionBankID(11L);
		examQuestionBank.setUseQuestionType(1L);
		examQuestionBankDao.add(examQuestionBank);
	}
	
	@Test
	public void testAddExamQuestionBank() {
		List<ExamQuestionBank> ls = new ArrayList<>();
		ExamQuestionBank examQuestionBank=new ExamQuestionBank();
		examQuestionBank.setQuestionCount(40);
		examQuestionBank.setUseExamID(2L);
		examQuestionBank.setUseQuestionBankID(13L);
		examQuestionBank.setUseQuestionType(5L);
		
		
		ls.add(examQuestionBank);
		
		int r=examQuestionBankDao.addExamQuestionBank(ls);
		System.out.println(r);
	}
	
	@Test
	public void testDel() {
		ExamQuestionBank examQuestionBank=new ExamQuestionBank();
		examQuestionBank.setExamQuestionBankID(2L);
		examQuestionBankDao.del(examQuestionBank);
	}
	
	@Test
	public void testQuery() {
		Exam exam=new Exam();
		exam.setExamID(2L);
		List<QuestionBankDto> ls=examQuestionBankDao.queryQuestionBankDtoByExam(exam);
		System.out.println(ls.size());
	}
	
	@Test
	public void testClean() {
		int r=examQuestionBankDao.clean(2L);
		System.out.println(r);
	}
	
	@Test
	public void testQueryQuestionBank() {
		List<QuestionBankDto> l=examQuestionBankDao.queryQuestionBankDtoByExamID(2L);
		System.out.println(l.get(0).toString());
	}
	
	@Test
	public void testQueryByExamID() {
		List<ExamQuestionBank> eqbs=examQuestionBankDao.queryByExamID(2L);
		System.out.println(eqbs.size());
	}
}
