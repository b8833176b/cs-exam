package com.ares.exam.dao;
import java.util.List;
import com.ares.exam.entity.ExamType;

/**
 * 考试类型接口
 * @author szares02
 *
 */
public interface ExamTypeDao {
	/**
	 * 添加考试类型
	 * @param examType
	 * @return
	 */
	int addExamType(ExamType examType);
	/**
	 * 删除考试
	 * @param examType
	 * @return
	 */
	int delExamType(ExamType examType);
	
	/**
	 * 查询所有考试类型
	 * @return
	 */
	List<ExamType> queryExamType();
	
	/**
	 * 更改考试类型
	 * @param examType
	 * @return
	 */
	int updateExamType(ExamType examType);
	
	/**
	 * 根据名称获取个数
	 * @param examTypeName
	 * @return
	 */
	int getConutByName(String examTypeName);
	
	/**
	 * 根据名称获取考试类型
	 * @param TypeName
	 * @return
	 */
	ExamType getExamTypeByName(String examTypeName);
	
}
