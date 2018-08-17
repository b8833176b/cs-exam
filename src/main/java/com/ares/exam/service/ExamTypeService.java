package com.ares.exam.service;
import java.util.List;
import com.ares.exam.entity.ExamType;
import com.ares.exam.exception.NameRepeatException;
import com.ares.exam.exception.ParameterNullException;
public interface ExamTypeService {
	
	/**
	 * 查询所有考试类型
	 * @return
	 */
	List<ExamType> queryExamTypeList();
	
	/**
	 * 添加考试类型
	 * @param examType
	 * @return
	 * @throws NameRepeatException 名称重复
	 * @throws ParameterNullException 参数为空异常
	 */
	int addExamType(ExamType examType)  throws NameRepeatException,ParameterNullException;
	
	/**
	 * 删除考试类型
	 * @param examType
	 * @return
	 */
	int delExamType(ExamType examType);
	
	/**
	 * 更新题库类型
	 * @param examType
	 * @return
	 * @throws ParameterNullException 
	 * @throws NameRepeatException 
	 */
	int updateExamType(ExamType examType) throws ParameterNullException, NameRepeatException;
}
