package com.ares.exam.dao;
import java.util.List;

import com.ares.exam.dto.PoliceInfoDto;
import com.ares.exam.dto.PoliceSelectCondition;
import com.ares.exam.entity.LzPoliceInfo;
import com.ares.exam.entity.PoliceInfo;
import com.ares.exam.entity.PoliceSelect;

public interface PoliceInfoDao {

	/**
	 * 查询 警员信息详细信息 根据ID
	 * @param userID 警员ID
	 * @return
	 */
	LzPoliceInfo queryLzPoliceInfo(long userID);

	/**
	 * 查询警员信息根据ID
	 * @param userID 警员ID
	 * @return
	 */
	PoliceInfo queryPoliceInfo(long userID);
	
	/**
	 * 根据用户名和密码查询用户，用于登陆
	 * @param police
	 * @return
	 */
	PoliceInfo queryPoliceInfoByUserAndPwd(PoliceInfo police);
	
	/**
	 * 根据条件查询警员信息
	 * @param policeInfo 警员信息集合
	 * @return
	 */
	List<PoliceInfo> queryPoliceInfoList(PoliceInfo policeInfo);

	List<PoliceSelect> getPoliceSelectList(PoliceSelectCondition condition);

	/**
	 *  根据条件查询警员封装信息
	 * @param policeInfo
	 * @return
	 */
	List<PoliceInfoDto> queryPoliceInfoDtoList(PoliceInfo policeInfo);
	
	/**
	 * 根据id集合获取警员信息列表
	 * @param ids
	 * @return
	 */
	List<PoliceInfo> queryPoliceInfoListByExcel(List<Long> ids);

	List<PoliceSelect> getPoliceSelectListByExcel(List<String> jhs);
	
	/**
	 * 根据id集合获取警员封装信息列表
	 * @param ids
	 * @return
	 */
	List<PoliceInfoDto> queryPoliceInfoDtoListByExcel(List<Long> ids);
}
