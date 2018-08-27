package com.ares.exam.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ares.exam.dto.*;
import com.ares.exam.entity.Answer;
import com.ares.exam.entity.AnswerSheet;
import com.ares.exam.entity.Exam;
import com.ares.exam.entity.ExamPoliceInfo;
import com.ares.exam.exception.NotExistException;
import com.ares.exam.exception.ParameterNullException;

public interface AnswerSheetService{
	
	/**
	 * 给客观题判断正确性                                   
	 * @param answers 
	 * @param exam                     
	 * @return                              
	 * @throws ParameterNullException 
	 * @throws NotExistException               
	 */
	public List<Answer>  getMark(List<Answer> answers,Exam exam) throws ParameterNullException, NotExistException;
	
	/**
	 * 保存答卷，并给客观题给出分数 
	 * @param answers
	 * @param exam                  
	 * @return                          
	 * @throws ParameterNullException  
	 * @throws NotExistException       
	 */
	public int save(List<Answer> answers,Exam exam) throws ParameterNullException, NotExistException;
	
	/**
	 * 保存或修改评卷                                      
	 * @param answers
	 * @return
	 * @throws ParameterNullException
	 * @throws NotExistException
	 */
	public int update(List<Answer> answers)throws ParameterNullException, NotExistException;
	
	/**
	 * 考生交卷
	 * @param epi
	 * @param answers
	 * @return
	 * @throws NotExistException 
	 * @throws ParameterNullException 
	 */
	public String submit(ExamPoliceInfo epi,List<Answer> answers) throws NotExistException, ParameterNullException;
	
	/**
	 * 获取答题
	 * @param answerSheetID
	 * @return
	 * @throws ParameterNullException 
	 */
	public List<AnswerDto> queryAnswerDto(Long answerSheetID) throws ParameterNullException;
	
	/**
	 * 统计分数
	 * @param answerSheetID 答题卷ID
	 */
	public String loadMark(Long answerSheetID);
	
	/**
	 * 根据考试ID，和用户ID获取试卷类
	 * @param examID
	 * @param userID
	 * @return
	 * @throws ParameterNullException 
	 */
	public AnswerSheet getAnswerSheet(Long examID,Long userID) throws ParameterNullException; 
	
	/**
	 * 获取考试考试封装信息
	 * @param exam
	 * @return
	 * @throws ParameterNullException
	 */
	public List<AnswerSheetDto> queryAnswerSheetDtosByExam(Exam exam) throws ParameterNullException;;

	List<AnswerSheetDto> queryManualMark(ManualMarkCondition condition);

	/**
	 * 根据考试ID，和用户ID获取答题
	 * @param examID
	 * @param userID
	 * @return
	 * @throws ParameterNullException 
	 * @throws NotExistException 
	 */
	public List<AnswerDto> queryAnswerDto(Long examID,Long userID) throws ParameterNullException, NotExistException;
	
	/**
	 * 查询成绩
	 * @param qasd
	 * @return
	 * @throws ParameterNullException 
	 */
	public List<ExamResultDto> queryExamResultDtos(QueryAnswerSheetDto qasd) throws ParameterNullException;
	
	/**
	 * 查询成绩并导出
	 * @param qasd
	 * @param session
	 * @param request
	 * @param response
	 * @throws ParameterNullException 
	 */
	public void exportExcelByQuery(QueryAnswerSheetDto qasd,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ParameterNullException;
	
/*	*//**
	 * 导出电子表格
	 * @param erds
	 * @param session
	 * @param request
	 * @param response
	 *//*
	public void exportExcel(List<ExamResultDto> erds,HttpSession session,HttpServletRequest request,HttpServletResponse response);*/
}
