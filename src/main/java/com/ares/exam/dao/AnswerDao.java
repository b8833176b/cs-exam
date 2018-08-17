package com.ares.exam.dao;
/**
 * 答题接口
 * @author szares02
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ares.exam.dto.AnswerDto;
import com.ares.exam.entity.Answer;

public interface AnswerDao {
	
	/**
	 * 根据答题卷ID获取答题集合
	 * @param answerSheetID
	 * @return
	 */
	List<Answer> queryAnswerByAnswerSheetID(Long answerSheetID);
	
	/**
	 * 删除答题
	 * @param answerID
	 * @return
	 */
	int delAnswer(Long answerID);
	
	/**
	 * 添加一条答题
	 * @param answer
	 * @return
	 */
	int addAnswer(@Param("answer") Answer answer); 
	
	/**
	 * 批量添加答题
	 * @param answers 答题类集合
	 * @return
	 */
	int inserAnswer(List<Answer> answers);
	
	/**
	 * 批量更新答题
	 * @param answers 答题类
	 * @return
	 */
	int updateAnswer(List<Answer> answers);
	
	/**
	 * 获取试卷中指定类型试题的数量
	 * @param questionType
	 * @param answerSheetID
	 * @return
	 */
	int getConut(@Param("questionType") Integer questionType,@Param("answerSheetID") Long answerSheetID);
	
	/**
	 * 根据ID获取答题
	 * @param answerID 答题ID
	 * @return
	 */
	Answer get(Long answerID);
	
	/**
	 * 获取试卷中指定类型的全部答题
	 * @param questionType 
	 * @param answerSheetID 
	 * @return
	 */
	List<Answer> queryAnswerByType(@Param("questionType") Integer questionType,@Param("answerSheetID") Long answerSheetID);
	
	
	/**
	 * 获取答题封装
	 * @param questionType
	 * @param answerSheetID
	 * @return
	 */
	List<AnswerDto>  queryAnswerDtoByType(@Param("questionType") Integer questionType,@Param("answerSheetID") Long answerSheetID);
	
	/**
	 * 更新一道答题
	 * @param answer
	 * @return
	 */
	int updateAnswer(@Param("answer")  Answer answer);
	
	
	/**
	 * 根据考卷获取答题（目前只包括问答题和填空题）
	 * @param answerSheetID
	 * @return
	 */
	List<AnswerDto> queryAnswerDto(Long answerSheetID);
	
	/**
	 * 清空答卷
	 * @param answerSheetID 考试答卷ID
	 * @return 影响行数
	 */
	int clean(Long answerSheetID);
	
	/**
	 * 获得答卷中未打分的试题数量
	 * @param answerSheetID 考试答卷ID
	 * @return 数目
	 */
	int getNoMarkCount(Long answerSheetID);
}
