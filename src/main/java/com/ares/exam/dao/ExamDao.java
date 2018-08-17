package com.ares.exam.dao;

import java.util.List;
import com.ares.exam.dto.ExamDto;
import com.ares.exam.entity.Exam;
import com.ares.exam.entity.PoliceInfo;

/**
 * 考试接口
 * @author szares02
 *
 */
public interface ExamDao {

	int countExamByNameWhenAdd(String name);

	int countExamByNameWhenUpdate(Exam exam);

	/**
	 * 添加考试
	 * @param exam
	 * @return
	 */
	long addExam(Exam exam);
	
	/**
	 * 删除考试
	 * @param exam
	 * @return
	 */
	int delExam(Exam exam);
	
	/**
	 * 修改考试基本信息
	 * @param exam 
	 * @return
	 */
	int updateExam(Exam exam);
	
	/**
	 * 获取考试
	 * @param examID
	 * @return
	 */
	Exam getExam(Long examID);
	
	/**
	 * 根据考试名称获取考试
	 * @param examName
	 * @return
	 */
	Exam getExamByName(String examName);
	
	/**
	 * 获取考生信息
	 * @param examID 考试ID
	 * @return
	 */
	ExamDto getExamDto(Long examID);
	
	/**
	 * 查询所有考试
	 * @return
	 */
	List<Exam> queryExam();
	
	/**
	 * 根据条件查询考试
	 * @param exam
	 * @return
	 */
	List<ExamDto> queryExamDto(ExamDto examDto);
	
	/**
	 * 根据考生获取当前可以参加的考试
	 * @param policeInfo
	 * @return
	 */
	List<ExamDto> queryExamDtoByUser(PoliceInfo policeInfo);
	
	/**
	 * 根据考生获取缺考的考试
	 * @param policeInfo
	 * @return
	 */
	List<ExamDto> queryMissExamDtoByUser(PoliceInfo policeInfo);
	
	/**
	 * 根据考生查询已经参加完成的考试
	 * @param policeInfo
	 * @return
	 */
	List<ExamDto> queryBeforeExamDtoByUser(PoliceInfo policeInfo);
}
