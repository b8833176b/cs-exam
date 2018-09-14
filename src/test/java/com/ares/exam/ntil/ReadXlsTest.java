package com.ares.exam.ntil;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ares.exam.BaseTest;
import com.ares.exam.dao.QuestionDao;
import com.ares.exam.service.QuestionService;
import com.ares.exam.service.impl.QuestionServiceImpl;


public class ReadXlsTest extends BaseTest{
	
	QuestionService questionService=new QuestionServiceImpl();
	@Autowired
	QuestionDao questionDao;
	@Test
	public void TestReadXlsTest() throws FileNotFoundException, IOException {
//		File f=new File("D://题库建设模板.xls");
	//	Map<Integer, List<Question>> map=questionService.ReadXls(f);
	//	questionDao.insertQuestionRadio(map.get(1));
//		System.out.println(map.get(1).get(0).toString());
	}

	@Test
	public void Test11() {
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);

		System.out.println(i1 == i2);

		Integer i3 = 127;
		Integer i4 = 127;
		Integer i5 = new Integer(127);

		System.out.println(i3 == i4);
		System.out.println(i3 == i5);

		int a=257;
		Integer b=257;
		System.out.println(b == a);
	}

}
