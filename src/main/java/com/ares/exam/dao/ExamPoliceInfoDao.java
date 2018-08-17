package com.ares.exam.dao;

import java.util.List;

import com.ares.exam.entity.PoliceSelect;
import org.apache.ibatis.annotations.Param;

import com.ares.exam.dto.ExamDto;
import com.ares.exam.dto.PoliceInfoDto;
import com.ares.exam.entity.Exam;
import com.ares.exam.entity.ExamPoliceInfo;
import com.ares.exam.entity.PoliceInfo;

/**
 * 考试与考试多对多 接口
 * @author szares02
 *
 */
public interface ExamPoliceInfoDao{
	
	/**
	 * 增加一条映射
	 * @param examPoliceInfo
	 * @return
	 */
	int add(ExamPoliceInfo examPoliceInfo);
	
	/**
	 * 删除一条映射
	 * @param examPoliceInfo
	 * @return
	 */
	int del(ExamPoliceInfo examPoliceInfo);
	
	
	/**
	 * 清空对应考试的与考生信息
	 * @param examID
	 * @return
	 */
	int clean(Long examID);
	
	/**
	 * 根据考试ID和考生ID获取映射
	 * @param examID
	 * @param userID
	 * @return
	 */
	ExamPoliceInfo get(@Param("examID") Long examID,@Param("userID") Long userID);
	
	/**
	 * 根据考试获取考试信息
	 * @param exam
	 * @return
	 */
	List<PoliceInfo> queryPoliceInfoDtoByExam(Exam exam);
	
	/**
	 * 根据考试ID考试信息
	 * @param examID
	 * @return
	 */
	List<PoliceInfoDto> getPoliceInfoDtoByExamID(Long examID);

	List<PoliceSelect> getPoliceSelectByExamID(Long examID);

	/**
	 * 根据用户未完成的考试
	 * @param policeInfo
	 * @return
	 */
	List<ExamDto> queryNotOver(PoliceInfo policeInfo);
	
	/**
	 * 获取以完成的考试
	 * @param policeInfo
	 * @return
	 */
	List<ExamDto> queryIsOver(PoliceInfo policeInfo);
	
 	
	/**
	 * 批量添加映射
	 * @param list
	 * @return
	 */
	int addExamPoliceInfo(List<ExamPoliceInfo> list);
	
	/**
	 * 更新考试状态
	 * @param state
	 * @return
	 */
	int updateState(ExamPoliceInfo examPoliceInfo);
}
