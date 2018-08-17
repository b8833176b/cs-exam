package com.ares.exam.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

import com.ares.exam.entity.Question;
import com.ares.exam.exception.ParameterNullException;

/**
 * 试题接口
 * @author szares02
 *
 */
public interface QuestionService {
	/**
	 * 删除试题接口
	 * @param question
	 * @return
	 * @throws ParameterNullException 
	 * @throws SQLIntegrityConstraintViolationException 
	 */
	int delQuestion(Long questionID) throws ParameterNullException, SQLIntegrityConstraintViolationException;
	
	/**
	 * 更新试题
	 * @param question
	 * @return
	 * @throws ParameterNullException
	 */
	int updateQuestion(Question question) throws ParameterNullException;
	
	/**
	 * 读取xls电子表格文件
	 * @param file 文件对象
	 * @return 
	 */
	public Map<Integer, List<Question>> ReadXls(Workbook hwb) throws FileNotFoundException, IOException;
	
	/**
	 * 添加试题
	 * @param Type 试题类型
	 * @param list 试题集合
	 */
	int insertQuestion(int Type,long questionBankID,List<Question> list);
	
	
	
	/**
	 * 获取题库下的所有试题
	 * @param questionBankID
	 * @return
	 */
	List<Question> getQuestionsByBankID(long questionBankID);
}
