package com.ares.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ares.exam.dao.ExamTypeDao;
import com.ares.exam.entity.ExamType;
import com.ares.exam.exception.NameRepeatException;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.ExamTypeService;
import com.ares.exam.util.StringUtil;

@Service
public class ExamTypeServiceImpl implements ExamTypeService{
	@Autowired
	private ExamTypeDao examTypeDao;

	@Override
	public List<ExamType> queryExamTypeList() {
		// TODO Auto-generated method stub
		return examTypeDao.queryExamType();
	}

	@Override
	public int addExamType(ExamType examType) throws NameRepeatException, ParameterNullException {
		// TODO Auto-generated method stub
		return examTypeDao.addExamType(examType);
	}

	@Override
	public int delExamType(ExamType examType) {
		// TODO Auto-generated method stub
		return examTypeDao.delExamType(examType);
	}

	@Override
	public int updateExamType(ExamType examType) throws ParameterNullException, NameRepeatException {
		// TODO Auto-generated method stub
		if(StringUtil.isEmpty(examType.getExamTypeName())) {
			throw new ParameterNullException("参数为空");
		}
		if(examTypeDao.getConutByName(examType.getExamTypeName())>0) {
			throw new NameRepeatException("名称重复");
		}
		return examTypeDao.updateExamType(examType);
	}
	

	
	

}
