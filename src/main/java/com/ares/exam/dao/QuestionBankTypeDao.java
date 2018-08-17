package com.ares.exam.dao;

import java.util.List;

import com.ares.exam.entity.QuestionBankType;
/**
 * 题库类型Dao接口
 * @author szares02
 *
 */
public interface QuestionBankTypeDao {
	/**
	 * 添加题库类型
	 * @param questBankTypeName 类型名称
	 * @return 影响行数
	 */
	int addQuestionBankType(String questBankTypeName);
	
	/**
	 * 添加题库类型
	 * @param questBankTypeName
	 * @return
	 */
	int addQuestionBankType(QuestionBankType questBankTypeName);
	
	/**
	 * 获取所有的题库类型
	 * @return 题库类型集合
	 */
	List<QuestionBankType> queryQuestionBankType();
	
	/**
	 * 根据条件查询
	 * @param QuestionBankType 查询的条件
	 * @return 若没有查询到返回空
	 */
	List<QuestionBankType> queryQuestionBankType(QuestionBankType questionBankType);
	
	/**
	 * 删除对应ID的题库类型
	 * @param questionBankType
	 * @return
	 */
	int delQuestionBankType(QuestionBankType questionBankType);
	
	/**
	 * 获得题库类型和下面的所有题库
	 * @param getQuestionBankTypeID 题库类型ID
	 * @return
	 */
	QuestionBankType getQuestionBankType(long getQuestionBankTypeID);
	
	/**
	 * 更新题库类型
	 * @param questionBankType
	 * @return
	 */
	int updateQuestionBankType(QuestionBankType questionBankType);
	
	/**
	 * 获取对应名称的题库类型有几个防止重复
	 * @return
	 */
	int getConutByName(String questBankTypeName);
}
