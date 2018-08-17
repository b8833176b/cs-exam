package com.ares.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ares.exam.dao.TypeInfoDao;
import com.ares.exam.entity.DepartmentType;
import com.ares.exam.entity.PoliceRankType;
import com.ares.exam.entity.PostType;
import com.ares.exam.entity.UnitType;
import com.ares.exam.service.TypeInfoService;
@Service
public class TypeInfoServiceImpl implements TypeInfoService{
	@Autowired
	private TypeInfoDao typeInfoDao;

	@Override
	public List<DepartmentType> getDepartmentTypeList() {
		// TODO Auto-generated method stub
		return typeInfoDao.getDepartmentTypeList();
	}

	@Override
	public List<PoliceRankType> getPoliceRankTypeList() {
		// TODO Auto-generated method stub
		return typeInfoDao.getPoliceRankTypeList();
	}

	@Override
	public List<PostType> getPostTypeList() {
		// TODO Auto-generated method stub
		return typeInfoDao.getPostTypeList();
	}

	@Override
	public List<UnitType> getUnitTypeList() {
		// TODO Auto-generated method stub
		return typeInfoDao.getUnitTypeList();
	}
	
}
