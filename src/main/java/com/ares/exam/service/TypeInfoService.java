package com.ares.exam.service;

import java.util.List;

import com.ares.exam.entity.DepartmentType;
import com.ares.exam.entity.PoliceRankType;
import com.ares.exam.entity.PostType;
import com.ares.exam.entity.UnitType;

public interface TypeInfoService {
	
	/**
	 * 获取所有部门类型
	 * @return
	 */
	List<DepartmentType> getDepartmentTypeList();
	
	/**
	 * 获取所有警衔类型
	 * @return
	 */
	List<PoliceRankType> getPoliceRankTypeList();
	
	/**
	 * 获取所有职务类型
	 * @return
	 */
	List<PostType> getPostTypeList();
	
	/**
	 * 获取所有单位类型
	 * @return
	 */
	List<UnitType> getUnitTypeList();
}
