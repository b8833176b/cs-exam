package com.ares.exam.dao;

import java.util.List;

import com.ares.exam.dto.ManualMarkCondition;
import org.apache.ibatis.annotations.Param;

import com.ares.exam.dto.AnswerSheetDto;
import com.ares.exam.dto.ExamResultDto;
import com.ares.exam.dto.QueryAnswerSheetDto;
import com.ares.exam.entity.AnswerSheet;

/**
 * 答题卷类接口
 * @author szares02
 *
 */
public interface AnswerSheetDao {
	
	/**
	 * 新增一条试卷
	 * @param answerSheet 
	 * @return ID
	 */
	long add(AnswerSheet answerSheet);
	
	/**
	 * 删除答题卷
	 * @param answerSheetID 答题卷ID
	 * @return
	 */
	int del(Long answerSheetID);
	
	/**
	 * 修改答卷
	 * @param answerSheet
	 * @return
	 */
	int update(AnswerSheet answerSheet);
	
	/**
	 * 根据用户ID,考试ID获取对应的数量（防止重复）
	 * @param userID 用户ID
	 * @param examID 考试ID
	 * @return 行数
	 */
	int getConut(@Param("userID") Long userID,@Param("examID") Long examID);
	
	/**
	 * 获得分数
	 * @param answerSheetID
	 * @return
	 */
	Float markSum(Long answerSheetID);
	
	/**
	 * 
	 * 根据用户ID，考试ID获取考卷
	 * @param userID 用户id
	 * @param examID 考试id
	 * @return
	 */
	AnswerSheet getAnswerSheet(@Param("userID") Long userID,@Param("examID") Long examID);
	
	
	/**
	 * 获取考卷
	 * @param answerSheetID
	 * @return
	 */
	AnswerSheet get(Long answerSheetID);
	
	/**
	 * 获取考试信息列表
	 * @param examID 考试列表
	 * @return
	 */
	List<AnswerSheet> queryAnswerSheet(@Param("examID") Long examID);
	
	/**
	 * 根据考试ID获取答卷封装类
	 * @param examID
	 * @return
	 */
	List<AnswerSheetDto> queryAnswerSheetDtoByID(@Param("examID") Long examID);

	List<AnswerSheetDto> queryManualMark(ManualMarkCondition condition);
	
	/**
	 * 查询考试成绩
	 * @param qasd
	 * @return
	 */
	List<ExamResultDto> queryExamResultDtos(QueryAnswerSheetDto qasd);
}
