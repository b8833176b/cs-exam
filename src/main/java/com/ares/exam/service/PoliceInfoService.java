package com.ares.exam.service;

import java.util.List;

import com.ares.exam.dto.PoliceSelectCondition;
import com.ares.exam.dto.Result;
import com.ares.exam.entity.LzPoliceInfo;
import com.ares.exam.entity.PoliceSelect;
import org.apache.poi.ss.usermodel.Workbook;

import com.ares.exam.dto.PoliceInfoDto;
import com.ares.exam.entity.PoliceInfo;
import com.ares.exam.exception.ParameterNullException;

import javax.servlet.http.HttpSession;

public interface PoliceInfoService {

	/**
	 * 查询 警员信息详细信息 根据ID
	 * @param session 警员ID
	 * @return
	 */
	Result queryLzPoliceInfo(HttpSession session);

	/**
	 * 根据用户名
	 * @param policeInfo
	 * @return
	 * @throws ParameterNullException
	 */
	public PoliceInfo getByUserAndPwd(PoliceInfo policeInfo) throws ParameterNullException;
	
	/**
	 * 读取电子表格中的ID来返回用户信息列表
	 * @param hwb
	 * @return
	 */
	public List<PoliceSelect> getListByReadExcel(Workbook hwb);
	
	/**
	 * 根据考试ID获取考试人员信息
	 * @param ExamID
	 * @return
	 * @throws ParameterNullException 
	 */
	public List<PoliceInfoDto> getListByExamID(Long examID) throws ParameterNullException;
	

	/**
	 * 获取用户列表根据条件
	 * @param policeInfo
	 * @return
	 * @throws ParameterNullException 
	 */
	public List<PoliceInfo> getList(PoliceInfo policeInfo) throws ParameterNullException;

	/**
	 * 获取用户列表根据条件
	 * @param condition
	 * @return
	 * @throws ParameterNullException
	 */
	public List<PoliceSelect> getPoliceSelectList(PoliceSelectCondition condition) throws ParameterNullException;
	
}
