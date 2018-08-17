package com.ares.exam.service;

import java.util.List;

import com.ares.exam.entity.QuestionBankType;
import com.ares.exam.exception.NameRepeatException;
import com.ares.exam.exception.ParameterNullException;

/**
 * 题库类型业务接口
 * @author szares02
 *
 */
public interface QuestionBankTypeService {
	
	/**
	 * 添加题库类型
	 * @param questBankTypeName
	 * @return
	 */
	int addQuestionBankType(String questBankTypeName) throws NameRepeatException;
	
	/**
	 * 添加题库类型
	 * @param questionBankType 
	 * @return
	 */
	int addQuestionBankType(QuestionBankType questionBankType) throws NameRepeatException,ParameterNullException;
	
	/**
	 * 获取所有的题库类型
	 * @return 题库类型集合
	 */
	List<QuestionBankType> queryQuestionBankType();
	
	/**
	 * 删除题库类型
	 * @param questionBankType
	 * @return
	 */
	int	delQuestionBankType(QuestionBankType questionBankType);
	
	/**
	 * 根据id获取题库类型类
	 * @return
	 */
	QuestionBankType getQuestionBankType(QuestionBankType questionBankType);
	
	/**
	 * 更新题库类型
	 * @param questionBankType
	 * @return
	 * @throws ParameterNullException 
	 * @throws NameRepeatException 
	 */
	int updateQuestionBankType(QuestionBankType questionBankType) throws ParameterNullException, NameRepeatException;
}
