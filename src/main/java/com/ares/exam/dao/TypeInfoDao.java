package com.ares.exam.dao;

import java.util.List;
import com.ares.exam.entity.DepartmentType;
import com.ares.exam.entity.PoliceRankType;
import com.ares.exam.entity.PostType;
import com.ares.exam.entity.UnitType;

/**
 * 编号信息接口
 * @author szares02
 *
 */
public interface TypeInfoDao {
	
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
