package com.ares.exam.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ares.exam.dto.QueryQuestionBankDto;
import com.ares.exam.dto.QuestionBankDto;
import com.ares.exam.entity.QuestionBank;


public interface QuestionBankDao {
	/**
	 * 添加题库
	 * @param questionBank 题库实体类
	 * @return 影响行数
	 */
	int addQuestionBank(QuestionBankDto questionBankDto);
	
	/**
	 * 添加题库
	 * @param questionBank
	 * @return
	 */
	int addQuestionBank(QuestionBank questionBank);
	
	/**
	 * 删除题库
	 * @param questionBank
	 * @return
	 */
	int delQuestionBank(QuestionBank questionBank);
	
	/**
	 * 更新题库
	 * @param questionBank
	 * @return
	 */
	int updateQuestionBank(QuestionBank questionBank);
	
	/**
	 * 获取题库
	 * @param QuestionBankID
	 * @return
	 */
	QuestionBank get(Long QuestionBankID); 
	
	/**
	 * 查询所有题库
	 * @return
	 */                                                                                                                                                                                                                             
	List<QuestionBank> queryQuestionBank();
	
	/**
	 * 按条件查询所有题库
	 * @param questionBank 条件实体
	 * @return 结果集合
	 */
	List<QuestionBank> queryQuestionBank(QuestionBank questionBank);
	
	/**
	 * 按条件查询题库
	 * @param questionBankDto
	 * @return
	 */
	List<QuestionBankDto> queryQuestionBankDto(QueryQuestionBankDto queryQuestionBankDto);
	
	/**
	 * 查询题库中题目的数量
	 * @param questionBankID 试题ID
	 * @return
	 */
	int queryCount(Integer questionBankID);
	
	/**
	 * 查询题库中指定试题的数量
	 * @param quesionBankID 题库ID
	 * @param Type 试题类型
	 * @return
	 */
	int queryCountByType(@Param("quesionBankID") Long quesionBankID,@Param("type") Long type);
	

	
	/**
	 * 清空题库下的试题
	 * @param questionBankID 题库ID
	 * @return
	 */
	int clean(Long questionBankID);
}
