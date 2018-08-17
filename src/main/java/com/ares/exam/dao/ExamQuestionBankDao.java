package com.ares.exam.dao;

import java.util.List;

import com.ares.exam.dto.ExamQuestionBankDto;
import com.ares.exam.dto.QuestionBankDto;
import com.ares.exam.entity.Exam;
import com.ares.exam.entity.ExamQuestionBank;

/**
 * 考试与题库关系接口
 * @author szares02
 *
 */
public interface ExamQuestionBankDao {
	
	/**
	 * 添加一条映射
	 * @param examQuestionBank
	 * @return
	 */
	int add(ExamQuestionBank examQuestionBank);
	
	/**
	 * 删除映射关系
	 * @param examQuestionBank
	 * @return
	 */
	int del(ExamQuestionBank examQuestionBank);
	
	/**
	 * 根据考试查询所有的题库关系
	 * @param exam
	 * @return
	 */
	List<ExamQuestionBank> queryByExam(Exam exam);
	
	
	/**
	 * 根据考试ID查询题库关联信息
	 * @param examID
	 * @return
	 */
	List<ExamQuestionBank> queryByExamID(Long examID);
	
	
	/**
	 * 根据考试获取所有的题库
	 * @param exam
	 * @return
	 */
	List<QuestionBankDto> queryQuestionBankDtoByExam(Exam exam);
	
	
	/**
	 * 根据考试ID获取所有的题库
	 * @param examID
	 * @return
	 */
	List<QuestionBankDto> queryQuestionBankDtoByExamID(Long examID);
	
	/**
	 * 根据考试获取考试与题库关系封装信息
	 * @param examID
	 * @return
	 */
	List<ExamQuestionBankDto> queryExamQuestionBankDtoByExamID(Long examID);
	
	/**
	 * 批量添加关系
	 * @param list
	 * @return
	 */
	int addExamQuestionBank(List<ExamQuestionBank> list);
	
	/**
	 * 删除对应考试下的题库映射关系
	 * @param examID
	 * @return
	 */
	int clean(Long examID);
	
}
