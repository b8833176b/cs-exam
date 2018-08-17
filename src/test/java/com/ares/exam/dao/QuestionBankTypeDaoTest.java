package com.ares.exam.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ares.exam.BaseTest;
import com.ares.exam.entity.QuestionBankType;


public class QuestionBankTypeDaoTest extends BaseTest{
	@Autowired
	private  QuestionBankTypeDao questionBankTypeDao;
	@Test
	public void testAddQuestionBankType() throws Exception{
		/*QuestionBankType questionBankType=new QuestionBankType();
		questionBankType.setQuestBankTypeName();*/
		questionBankTypeDao.addQuestionBankType("插入测试XX");
	}
	@Test
	public void testAddQuestionBankType2() throws Exception{
		/*QuestionBankType questionBankType=new QuestionBankType();
		questionBankType.setQuestBankTypeName();*/
		questionBankTypeDao.addQuestionBankType(new QuestionBankType("abcd"));
	}
	@Test
	public void testQueryQuestionBankType() {
		List<QuestionBankType> ls= questionBankTypeDao.queryQuestionBankType();
		System.out.println(ls.size());
	}
	@Test
	public void testQueryQuestionBankType2() {
		QuestionBankType qbType=new QuestionBankType();
//		qbType.setQuestionBankTypeID(12L);
		qbType.setQuestionBankTypeName("哈哈");
		List<QuestionBankType> ls= questionBankTypeDao.queryQuestionBankType(qbType);
		System.out.println(ls.size());
	}
	@Test
	public void testDelQuestionBankType() {
		QuestionBankType qbType=new QuestionBankType();
		qbType.setQuestionBankTypeID(43L);
		int r=questionBankTypeDao.delQuestionBankType(qbType);
		System.out.println(r);
	}
	@Test
	public void testGetQuestionBankType() {
		QuestionBankType qbt=questionBankTypeDao.getQuestionBankType(4);
		System.out.println(qbt.getQuestionBanks().size());
	}
	@Test
	public void testUpdateQuestionBankType() {
		QuestionBankType questionBankType=new QuestionBankType();
		questionBankType.setQuestionBankTypeID(3L);
		questionBankType.setQuestionBankTypeName("测试");
		int r=questionBankTypeDao.updateQuestionBankType(questionBankType);
		System.out.println(r);
	}
	@Test
	public void testGetcount() {
		int r=questionBankTypeDao.getConutByName("测试");
		System.out.println(r+"---------------");
	}
}
