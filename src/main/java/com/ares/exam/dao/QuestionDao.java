package com.ares.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ares.exam.entity.Question;

public interface QuestionDao {
	
	/**
	 * 基本接口,删除试题
	 * @param question 试题ID
 	 * @return 影响行数
	 */
	int delQuestion(Long question);
	
	/**
	 * 根据试题ID获取试题
	 * @param questionID
	 * @return
	 */
	Question getQuestionById(Long questionID);
	
	
	/**
	 * 更新试题
	 * @param question
	 * @return
	 */
	int updateQuestion(Question question);
	
	/**
	 * 批量插入试题
	 * @param list  单选题集合
	 * @return
	 */
	int insertQuestion(List<Question> list);
	
	/**
	 * 获取对应题库下的试题
	 * @param quesionBankID 题库ID
	 * @return
	 */
	List<Question> queryQuestionByBankID(Long quesionBankID);
	
	/**
	 * 随机获取一定数目的指定类型的试题
	 * @param quesionBankID 题库ID
	 * @param count 个数
	 * @param type 类型
	 * @return
	 */
	List<Question> randomQueryQuestion(@Param("quesionBankID") Long quesionBankID,@Param("count") Integer count,@Param("type") Long type);

	/* 顺序获取一定数目的指定类型的试题*/
	List<Question> orderQueryQuestion(@Param("quesionBankID") Long quesionBankID,@Param("count") Integer count,@Param("type") Long type);

	
	
	
}
