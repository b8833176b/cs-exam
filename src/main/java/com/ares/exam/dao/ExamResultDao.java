package com.ares.exam.dao;

import java.util.List;

import com.ares.exam.entity.ExamResult;

public interface ExamResultDao {
	/**
	 * 添加一条考试成绩
	 * @param examResult
	 * @return
	 */
	int addExamResult(ExamResult examResult);
	
	/**
	 * 批量添加成绩
	 * @param examResults
	 * @return
	 */
	int insertExamResult(List<ExamResult> examResults);
	
	/**
	 * 根据考试查询考试成绩
	 * @param ExamID
	 * @return
	 */
	List<ExamResult> queryExamResultByExamID(Long ExamID);

}
